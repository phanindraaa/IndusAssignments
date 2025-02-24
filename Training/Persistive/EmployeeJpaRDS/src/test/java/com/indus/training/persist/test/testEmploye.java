package com.indus.training.persist.test;

import static org.junit.Assert.*;

import java.sql.Date;

import com.indus.training.persist.dao.EmployeeManagerJpa;
import com.indus.training.persist.entity.Employee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testEmploye {
	
	private EmployeeManagerJpa employeemanager;
	@Before
	public void setUp() throws Exception {
		employeemanager = new EmployeeManagerJpa();
	}

	@After
	public void tearDown() throws Exception {
		employeemanager = null;
	}

	@Test
	public void test() {
		
		EmployeeManagerJpa employeeDAO = new EmployeeManagerJpa();

        // Create a new employee
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Alice");
        newEmployee.setLastName("Wonderland");
        newEmployee.setEmail("alice.wonderland@example.com");
        newEmployee.setHireDate(Date.valueOf("2023-09-01"));

        // Save the employee
        employeeDAO.save(newEmployee);
        System.out.println("Employee saved: " + newEmployee.getEmployeeID());

        // Find employee by ID
        Employee foundEmployee = employeeDAO.findById(newEmployee.getEmployeeID());
        System.out.println("Found Employee: " + foundEmployee.getFirstName() + " " + foundEmployee.getLastName());

        // Update employee
        foundEmployee.setEmail("alice.new@example.com");
        employeeDAO.update(foundEmployee);
        System.out.println("Updated Employee Email: " + foundEmployee.getEmail());

        // Delete employee
        employeeDAO.delete(foundEmployee.getEmployeeID());
        System.out.println("Employee deleted");
		fail("Not yet implemented");
		
	}

}
