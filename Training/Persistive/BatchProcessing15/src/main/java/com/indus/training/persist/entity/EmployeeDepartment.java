package com.indus.training.persist.entity;

import javax.persistence.*;

@Entity
@Table(name = "EmployeeDepartment")
@IdClass(EmployeeDepartmentId.class)
public class EmployeeDepartment {
    
    @Id
    @Column(name = "EmployeeID")
    private Long employeeID;

    @Id
    @Column(name = "DepartmentID")
    private Long departmentID;

    // Getters and Setters
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
}
