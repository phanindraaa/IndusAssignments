package com.indus.training.persist.entity;

import javax.persistence.*;
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

    @ElementCollection
    @CollectionTable(name = "Addresses", joinColumns = @JoinColumn(name = "EmployeeID"))
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name = "fld_street")),
        @AttributeOverride(name = "city", column = @Column(name = "fld_city")),
        @AttributeOverride(name = "country", column = @Column(name = "fld_country"))
    })
    private Set<Address> addresses;

    // Constructors, Getters, and Setters
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
