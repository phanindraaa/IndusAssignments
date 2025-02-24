package com.indus.training.persist.entity;

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

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
