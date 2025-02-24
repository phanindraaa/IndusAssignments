package com.indus.training.persist.entity;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeDepartmentId implements Serializable {
    
    private Long employeeID;
    private Long departmentID;

    // Default constructor
    public EmployeeDepartmentId() {}

    // Getters, Setters, equals, and hashCode
    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDepartmentId)) return false;
        EmployeeDepartmentId that = (EmployeeDepartmentId) o;
        return Objects.equals(employeeID, that.employeeID) &&
                Objects.equals(departmentID, that.departmentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, departmentID);
    }
}
