package org.springpractice.springbootjpaadvanced.entity.onetooneuni;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    private int laptopId;

    private String modelNumber;

    private String brand;

    public Laptop() {
    }

    public Laptop(int laptopId, String modelNumber, String brand) {
        this.laptopId = laptopId;
        this.modelNumber = modelNumber;
        this.brand = brand;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
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
}
