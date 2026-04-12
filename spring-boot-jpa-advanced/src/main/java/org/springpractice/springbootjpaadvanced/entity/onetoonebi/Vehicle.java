package org.springpractice.springbootjpaadvanced.entity.onetoonebi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    private int vehicleId;

    private String modelNumber;

    private String brand;

    @OneToOne(mappedBy = "vehicle")
    private Tourist tourist;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, String modelNumber, String brand) {
        this.vehicleId = vehicleId;
        this.modelNumber = modelNumber;
        this.brand = brand;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }
}
