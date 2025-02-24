package com.indus.training.persist.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Long employeeID;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "Employee_Address",
        joinColumns = @JoinColumn(name = "EmployeeID"),
        inverseJoinColumns = @JoinColumn(name = "AddressID")
    )
    private Set<Address> addresses = new HashSet<>();

    // Constructor with all fields
    public Employee(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses.add(address);  // Initialize with one address
    }

    // Constructor with just first and last name
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Default constructor
    public Employee() {}

    // Getters and Setters
    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
