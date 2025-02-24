package com.indus.training.persist.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeDepartment")
public class EmployeeDepartment {

    @EmbeddedId
    private EmployeeDepartmentId id;

    // Constructors, Getters, and Setters
    public EmployeeDepartment() {}

    public EmployeeDepartment(EmployeeDepartmentId id) {
        this.id = id;
    }

    public EmployeeDepartmentId getId() {
        return id;
    }

    public void setId(EmployeeDepartmentId id) {
        this.id = id;
    }
}
