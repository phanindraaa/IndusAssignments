package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    private EmployeeDAO employeeDAO;

    @Before
    public void setUp() {
        employeeDAO = new EmployeeDAO();
    }

    @Test
    public void testSaveEmployee() {
        Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("123 Main St", "New York", "USA"));
        addresses.add(new Address("456 Broadway", "Los Angeles", "USA"));

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setAddresses(addresses);

        employeeDAO.saveEmployee(employee);

        assertNotNull(employee.getEmployeeID());  // Ensure employee is saved and ID is generated
    }

    @Test
    public void testGetEmployeeById() {
        // Step 1: Save a new employee
        Employee employee = new Employee();
        employee.setFirstName("TestFirstName");
        employee.setLastName("TestLastName");

        employeeDAO.saveEmployee(employee);
        Long employeeID = employee.getEmployeeID();

        // Step 2: Retrieve the saved employee using its ID
        Employee retrievedEmployee = employeeDAO.getEmployeeById(employeeID);

        // Step 3: Assert the employee was correctly retrieved
        assertNotNull(retrievedEmployee);  // Ensure employee was retrieved
        assertEquals("TestFirstName", retrievedEmployee.getFirstName());
        assertEquals("TestLastName", retrievedEmployee.getLastName());
    }

    @Test
    public void testGetAllEmployees() {
        assertNotNull(employeeDAO.getAllEmployees());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Jane");
        employee.setLastName("Doe");

        employeeDAO.saveEmployee(employee);
        Long employeeID = employee.getEmployeeID();
        assertNotNull(employeeID);

        employeeDAO.deleteEmployee(employeeID);

        assertNull(employeeDAO.getEmployeeById(employeeID));
    }

    @Test
    public void testUpdateEmployee() {
        // Step 1: Save a new employee
        Employee employee = new Employee();
        employee.setFirstName("InitialFirstName");
        employee.setLastName("InitialLastName");

        employeeDAO.saveEmployee(employee);
        Long employeeID = employee.getEmployeeID();

        // Step 2: Update the employee's last name
        employee.setLastName("UpdatedLastName");
        employeeDAO.updateEmployee(employee);

        // Step 3: Retrieve the updated employee and check if the last name was updated
        Employee updatedEmployee = employeeDAO.getEmployeeById(employeeID);
        assertNotNull(updatedEmployee);  // Ensure employee was retrieved
        assertEquals("UpdatedLastName", updatedEmployee.getLastName());  // Ensure last name was updated
    }

    @After
    public void tearDown() {
        employeeDAO = null;
    }
}
