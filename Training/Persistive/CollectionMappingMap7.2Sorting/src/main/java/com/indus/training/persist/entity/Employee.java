package com.indus.training.persist.entity;

import javax.persistence.*;
import java.util.Comparator;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;
    
    public Employee(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Employee() {
		// TODO Auto-generated constructor stub
	}

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Custom comparator to sort employees by last name
    public static class LastNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getLastName().compareTo(e2.getLastName());
        }
    }
}
