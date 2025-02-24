package com.indus.training.spring.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeProjects")
public class EmployeeProject {

    @EmbeddedId
    private EmployeeProjectId id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "projectId")
    private Project project;

    @Temporal(TemporalType.DATE)
    private Date assignmentDate;

    private int hoursWorked;

    // Constructors, Getters, Setters
    public EmployeeProject() {}

    public EmployeeProject(Employee employee, Project project, Date assignmentDate, int hoursWorked) {
        this.id = new EmployeeProjectId(employee.getEmployeeId(), project.getProjectId());
        this.employee = employee;
        this.project = project;
        this.assignmentDate = assignmentDate;
        this.hoursWorked = hoursWorked;
    }

	public EmployeeProjectId getId() {
		return id;
	}

	public void setId(EmployeeProjectId id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getAssignmentDate() {
		return assignmentDate;
	}

	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

    // Add custom getters and setters
}
