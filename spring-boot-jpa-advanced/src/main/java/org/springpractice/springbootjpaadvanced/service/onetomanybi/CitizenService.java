package org.springpractice.springbootjpaadvanced.service.onetomanybi;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springpractice.springbootjpaadvanced.entity.onetomanybi.Address;
import org.springpractice.springbootjpaadvanced.entity.onetomanybi.Citizen;
import org.springpractice.springbootjpaadvanced.repository.onetomanybi.AddressRepository;
import org.springpractice.springbootjpaadvanced.repository.onetomanybi.CitizenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;

    private final AddressRepository addressRepository;

    public CitizenService(CitizenRepository citizenRepository, AddressRepository addressRepository) {
        this.citizenRepository = citizenRepository;
        this.addressRepository = addressRepository;
    }

    //@PostConstruct
    public void init() {

        System.out.println("One to Many Bi Directional Mapping");
        System.out.println("Deleting all Data.");

        List<Address> addresses = addressRepository.findAll();
        addresses.forEach(a -> a.setCitizen(null));
        addressRepository.saveAll(addresses);

        addressRepository.deleteAll();
        citizenRepository.deleteAll();

        System.out.println("Saving Data.");

        Citizen citizen1 = new Citizen(123, "John", "ABC");
        Citizen citizen2 = new Citizen(124, "Mark", "ABCD");
        Citizen citizen3 = new Citizen(125, "Sean", "ABCDE");

        Address address1 = new Address(101, "1", "2nd", "New York");
        Address address2 = new Address(102, "23", "4th", "Boston");
        Address address3 = new Address(103, "34", "8th", "New York");
        Address address4 = new Address(104, "35", "9th", "New York");
        Address address5 = new Address(105, "36", "11th", "New York");

        address1.setCitizen(citizen1);
        address2.setCitizen(citizen1);
        address3.setCitizen(citizen2);
        address4.setCitizen(citizen2);
        address5.setCitizen(citizen3);

        citizenRepository.saveAll(List.of(citizen1, citizen2, citizen3));
        addressRepository.saveAll(List.of(address1, address2, address3, address4, address5));

        System.out.println("Saved Data.");
        System.out.println("Loading Data.");

        Optional<Citizen> citizen = citizenRepository.findById(123);
        citizen.ifPresent(c -> c.getAddresses().forEach(a -> System.out.println(a.getAddressId())));

        System.out.println("Deleting Citizen.");

        citizenRepository.deleteById(125);

        System.out.println("Address size after deletion.");

        System.out.println(addressRepository.findAll().size());

    }

}
