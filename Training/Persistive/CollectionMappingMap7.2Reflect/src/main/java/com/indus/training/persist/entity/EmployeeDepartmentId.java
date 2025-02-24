package com.indus.training.persist.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeDepartmentId implements Serializable {
    private static final long serialVersionUID = 1L;  // Adding serialVersionUID

    @Column(name = "EmployeeID")
    private Long employeeID;

    @Column(name = "DepartmentID")
    private Long departmentID;

    // Constructors, Getters, and Setters
    public EmployeeDepartmentId() {}

    public EmployeeDepartmentId(Long employeeID, Long departmentID) {
        this.employeeID = employeeID;
        this.departmentID = departmentID;
    }

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

        if (!getEmployeeID().equals(that.getEmployeeID())) return false;
        return getDepartmentID().equals(that.getDepartmentID());
    }

    @Override
    public int hashCode() {
        int result = getEmployeeID().hashCode();
        result = 31 * result + getDepartmentID().hashCode();
        return result;
    }
}
