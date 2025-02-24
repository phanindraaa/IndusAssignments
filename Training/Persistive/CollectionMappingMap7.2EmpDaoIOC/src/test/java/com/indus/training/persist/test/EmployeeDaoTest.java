package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeDaoTest {

    private EmployeeDAO employeeDAO;
    private Employee testEmployee;
    private Long testEmployeeId;

    @Before
    public void setUp() {
        employeeDAO = new EmployeeDAO();
    	

        // Create an address and employee for testing
        Address address = new Address("123 Main St", "New York", "USA");
        testEmployee = new Employee("John", "Doe", address);
        
        // Save the employee to get a valid ID
        employeeDAO.saveEmployee(testEmployee);
        testEmployeeId = testEmployee.getEmployeeID();
    }

    @After
    public void tearDown() {
        // Clean up by deleting the test employee
        if (testEmployeeId != null) {
            employeeDAO.deleteEmployee(testEmployeeId);
        }
    }

    @Test
    public void testSaveEmployee() {
        // Employee should be saved and have a valid ID
        Assert.assertNotNull("Employee ID should not be null after saving", testEmployee.getEmployeeID());
    }

    @Test
    public void testGetEmployee() {
        // Fetch the employee from the database
        Employee retrievedEmployee = employeeDAO.getEmployee(testEmployeeId);

        // Verify that the retrieved employee matches the saved one
        Assert.assertNotNull("Employee should be retrieved", retrievedEmployee);
        Assert.assertEquals("Employee first name should match", "John", retrievedEmployee.getFirstName());
        Assert.assertEquals("Employee last name should match", "Doe", retrievedEmployee.getLastName());
//        Assert.assertEquals("Employee address should match", "123 Main St", retrievedEmployee.getAddress().getStreet());
    }

    @Test
    public void testDeleteEmployee() {
        // Delete the employee
        employeeDAO.deleteEmployee(testEmployeeId);

        // Try to fetch the deleted employee
        Employee deletedEmployee = employeeDAO.getEmployee(testEmployeeId);

        // Employee should be null after deletion
        Assert.assertNull("Employee should be null after deletion", deletedEmployee);

        // Mark the employee as deleted to prevent clean up in tearDown
        testEmployeeId = null;
    }
    
    @Test
    public void testGetEmployeeDetails() {
    	employeeDAO = null;
    	String Path = null;
    	try (BufferedReader fileContent = new BufferedReader(new FileReader("classFile.txt"))) {
			String filePath = fileContent.readLine();
			Path = filePath.split("=")[1];
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   		
    
    	try {
			@SuppressWarnings("rawtypes")
			Class tempEmployee  = Class.forName(Path);
			Object testObj = null;
			try {
				testObj = tempEmployee.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			employeeDAO = (EmployeeDAO) testObj;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Employee fetchedEmp = employeeDAO.getEmployee(testEmployeeId);
		assertNotNull(fetchedEmp);
		assertEquals("John", fetchedEmp.getFirstName());
		assertEquals("Doe", fetchedEmp.getLastName());
    }
}
