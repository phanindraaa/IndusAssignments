package com.indus.training.persist.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeComposite implements Serializable {

    private Long employeeID;
    private String firstName;
    private String lastName;

    // Constructors, Getters, and Setters

    public EmployeeComposite() {}

    public EmployeeComposite(Long employeeID, String firstName, String lastName) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeComposite that = (EmployeeComposite) o;

        if (!employeeID.equals(that.employeeID)) return false;
        if (!firstName.equals(that.firstName)) return false;
        return lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        int result = employeeID.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
