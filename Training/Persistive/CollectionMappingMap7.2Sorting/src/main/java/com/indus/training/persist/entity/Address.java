package com.indus.training.persist.entity;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import javax.persistence.*;
import java.util.SortedSet;
import java.util.TreeSet;

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

    @OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID")
    @Sort(type = SortType.COMPARATOR, comparator = Employee.LastNameComparator.class)
    private SortedSet<Employee> employees = new TreeSet<>(new Employee.LastNameComparator());

    
    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
    
    public Address() {
		// TODO Auto-generated constructor stub
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

    public SortedSet<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(SortedSet<Employee> employees) {
        this.employees = employees;
    }
}
