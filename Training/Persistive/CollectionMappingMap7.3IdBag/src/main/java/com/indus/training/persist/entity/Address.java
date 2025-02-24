package com.indus.training.persist.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private Long addressID;

    @Column(name = "Street", nullable = false)
    private String street;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "Country", nullable = false)
    private String country;

    // Mapping of Employee ID (as key) to Employee entity (as value)
    @ElementCollection
    @CollectionTable(name = "Employee", joinColumns = @JoinColumn(name = "AddressID"))
    @MapKeyColumn(name = "EmployeeID")
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Map<Long, Employee> employees = new HashMap<>();

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Address() {}

    // Getters and Setters
    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<Long, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Long, Employee> employees) {
        this.employees = employees;
    }
}
