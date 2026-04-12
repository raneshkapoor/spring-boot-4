package org.springpractice.springbootjpaadvanced.entity.onetoonebi;

import jakarta.persistence.*;

@Entity
@Table(name = "tourist")
public class Tourist {

    @Id
    private int touristId;

    private String touristName;

    private String about;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Tourist() {
    }

    public Tourist(int touristId, String touristName, String about, Vehicle vehicle) {
        this.touristId = touristId;
        this.touristName = touristName;
        this.about = about;
        this.vehicle = vehicle;
    }

    public int getTouristId() {
        return touristId;
    }

    public void setTouristId(int touristId) {
        this.touristId = touristId;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
