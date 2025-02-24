package com.indus.training.spring.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeProjectId implements Serializable {

    private int employeeId;
    private int projectId;

    // Constructors, Getters, Setters, hashCode, equals
    public EmployeeProjectId() {}

    public EmployeeProjectId(int employeeId, int projectId) {
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

    // Implement hashCode() and equals() based on both fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProjectId that = (EmployeeProjectId) o;
        return employeeId == that.employeeId && projectId == that.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectId);
    }

    // Add custom getters and setters
}
