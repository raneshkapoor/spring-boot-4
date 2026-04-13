package org.springpractice.springbootjpaadvanced.entity.onetomanybi;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "citizen")
public class Citizen {

    @Id
    private int citizenId;

    private String citizenName;

    private String citizenDetails;

    @OneToMany(mappedBy = "citizen", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    List<Address> addresses;

    public Citizen() {
    }

    public Citizen(int citizenId, String citizenName, String citizenDetails) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenDetails = citizenDetails;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getCitizenDetails() {
        return citizenDetails;
    }

    public void setCitizenDetails(String citizenDetails) {
        this.citizenDetails = citizenDetails;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
