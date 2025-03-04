package com.indus.training.spring.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

    // Constructors
    public Employee() {}

    public Employee(String firstName, String lastName, String email, BigDecimal  salary) {
        this.firstName = Objects.requireNonNull(firstName, "First name must not be null");
        this.lastName = Objects.requireNonNull(lastName, "Last name must not be null");
        this.email = Objects.requireNonNull(email, "Email must not be null");
        this.salary = Objects.requireNonNull(salary, "Salary must not be null");
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName, "First name must not be null");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Objects.requireNonNull(lastName, "Last name must not be null");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email, "Email must not be null");
    }

    public BigDecimal  getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal d) {
        this.salary = Objects.requireNonNull(d, "Salary must not be null");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}