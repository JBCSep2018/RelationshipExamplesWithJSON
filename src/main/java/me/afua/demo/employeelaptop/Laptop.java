package me.afua.demo.employeelaptop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Laptop {

    @GeneratedValue()
    @Id
    private long id;
    private String make;
    private String model;
    private String serialNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Laptop() {
    }

    public Laptop(String make, String model, String serialNumber) {
        this.make = make;
        this.model = model;
        this.serialNumber = serialNumber;
    }
}
