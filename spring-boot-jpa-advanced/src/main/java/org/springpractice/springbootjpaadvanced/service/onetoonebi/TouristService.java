package org.springpractice.springbootjpaadvanced.service.onetoonebi;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springpractice.springbootjpaadvanced.entity.onetoonebi.Vehicle;
import org.springpractice.springbootjpaadvanced.entity.onetoonebi.Tourist;
import org.springpractice.springbootjpaadvanced.repository.onetoonebi.VehicleRepository;
import org.springpractice.springbootjpaadvanced.repository.onetoonebi.TouristRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    private final VehicleRepository vehicleRepository;

    private final TouristRepository touristRepository;

    public TouristService(VehicleRepository vehicleRepository, TouristRepository touristRepository) {
        this.vehicleRepository = vehicleRepository;
        this.touristRepository = touristRepository;
    }

    //@PostConstruct
    public void init() {

        System.out.println("One to One Bi Directional Mapping");

        System.out.println("Deleting all Data.");

        List<Tourist> tourists = touristRepository.findAll();
        tourists.forEach(tourist -> tourist.setVehicle(null));
        touristRepository.saveAll(tourists);

        touristRepository.deleteAll();
        vehicleRepository.deleteAll();

        System.out.println("Saving Data.");

        Vehicle vehicle1 = new Vehicle(123, "ABC", "Dell");
        Vehicle vehicle2 = new Vehicle(124, "ABD", "Dell");
        Vehicle vehicle3 = new Vehicle(125, "ABE", "Dell");
        Vehicle vehicle4 = new Vehicle(126, "ABF", "HP");

        Tourist tourist1 = new Tourist(101, "John", "Student", vehicle1);
        Tourist tourist2 = new Tourist(102, "Mark", "Student", vehicle4);

        vehicleRepository.saveAll(List.of(vehicle1, vehicle2, vehicle3, vehicle4));
        touristRepository.saveAll(List.of(tourist1, tourist2));

        System.out.println("Saved Data.");
        System.out.println("Loading Data.");
        System.out.println("Loading tourist vehicle.");

        Optional<Tourist> tourist = touristRepository.findById(101);
        tourist.ifPresent(s -> System.out.println(s.getVehicle().getBrand()));

        System.out.println("Loading tourist from Vehicle");

        Optional<Vehicle> vehicle = vehicleRepository.findById(123);
        vehicle.ifPresent(v -> System.out.println(v.getTourist().getTouristName()));

        System.out.println("Deleting Tourist.");

        if (tourist.isPresent()) {
            Tourist touristToUpdate = tourist.get();
            touristToUpdate.setVehicle(null);
            touristRepository.save(touristToUpdate);
        }

        touristRepository.deleteById(101);

        System.out.println("Vehicle Size after deleting tourist.");

        System.out.println(vehicleRepository.findAll().size());

    }

}
