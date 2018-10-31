package me.afua.demo.employeelaptop;

import javax.persistence.*;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String firstName;

    private String LastName;

    @OneToOne(cascade = CascadeType.ALL)
    private Laptop myLaptop;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Laptop getMyLaptop() {
        return myLaptop;
    }

    public void setMyLaptop(Laptop myLaptop) {
        this.myLaptop = myLaptop;
    }

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        LastName = lastName;
    }

    public Employee(String firstName, String lastName, Laptop myLaptop) {
        this.firstName = firstName;
        LastName = lastName;
        this.myLaptop = myLaptop;
    }
}
