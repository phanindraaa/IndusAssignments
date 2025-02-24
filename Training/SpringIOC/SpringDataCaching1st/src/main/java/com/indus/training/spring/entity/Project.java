package com.indus.training.spring.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    private String projectName;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private double budget;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<EmployeeProject> employeeProjects = new HashSet<>();

    // Constructors, Getters, Setters
    public Project() {}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Set<EmployeeProject> getEmployeeProjects() {
		return employeeProjects;
	}

	public void setEmployeeProjects(Set<EmployeeProject> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

    // Add custom constructor, getters and setters
}
