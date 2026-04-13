package org.springpractice.springbootjpaadvanced.entity.onetomanybi;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    private int addressId;

    private String houseNo;

    private String street;

    private String city;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Citizen citizen;

    public Address() {
    }

    public Address(int addressId, String houseNo, String street, String city) {
        this.addressId = addressId;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
