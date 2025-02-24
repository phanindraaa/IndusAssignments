package com.indus.training.persist.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import com.indus.training.persist.entity.Employee.TicketComparator;

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

    // Map of employees, where the key is EmployeeID
    @OneToMany
    @JoinColumn(name = "AddressID")  // Foreign key in Employee table
    @MapKeyColumn(name = "EmployeeID")  // Map key is EmployeeID
    @Sort(type = SortType.COMPARATOR, comparator = TicketComparator.class)
    private Map<Long, Employee> employees = new HashMap<>();
    
    public Address() {}

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

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
