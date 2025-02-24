package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeManagerJpa;
import com.indus.training.persist.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class testEmployee {

    private EmployeeManagerJpa employeeDAO;
    private Employee newEmployee;

    @Before
    public void setUp() throws Exception {
        employeeDAO = new EmployeeManagerJpa();

        // Create a new employee before each test
        newEmployee = new Employee();
        newEmployee.setFirstName("Alice");
        newEmployee.setLastName("Wonderland");
        newEmployee.setEmail("alice.wonderland@example.com");
        newEmployee.setHireDate(Date.valueOf("2023-09-01"));

        employeeDAO.save(newEmployee);
        assertNotNull("Employee ID should not be null after save", newEmployee.getEmployeeID());
    }

    @Test
    public void testFindById() {
        // Find employee by ID
        Employee foundEmployee = employeeDAO.findById(newEmployee.getEmployeeID());
        assertNotNull("Employee should be found", foundEmployee);
        assertEquals("First name should match", "Alice", foundEmployee.getFirstName());
    }

    @Test
    public void testUpdateEmployee() {
        // Update employee email
        newEmployee.setEmail("alice.new@example.com");
        employeeDAO.update(newEmployee);

        // Verify the update
        Employee updatedEmployee = employeeDAO.findById(newEmployee.getEmployeeID());
        assertEquals("Email should be updated", "alice.new@example.com", updatedEmployee.getEmail());
    }

    @Test
    public void testDeleteEmployee() {
        // Delete the employee
        employeeDAO.delete(newEmployee.getEmployeeID());

        // Verify that the employee no longer exists
        Employee deletedEmployee = employeeDAO.findById(newEmployee.getEmployeeID());
        assertNull("Employee should be deleted", deletedEmployee);
    }

    @After
    public void tearDown() throws Exception {
        // Cleanup after each test
        if (employeeDAO.findById(newEmployee.getEmployeeID()) != null) {
            employeeDAO.delete(newEmployee.getEmployeeID());
        }
    }
}
