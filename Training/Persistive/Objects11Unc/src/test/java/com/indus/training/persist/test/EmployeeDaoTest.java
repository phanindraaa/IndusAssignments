package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    private EmployeeDAO employeeDAO;
    private Employee employee;

    @Before
    public void setUp() {
        employeeDAO = new EmployeeDAO();
        employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
    }
    @Test
    public void testSaveEmployee() {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Create an Address object
        Address address1 = new Address("123 Elm St", "Springfield", "USA");
        System.out.println("Address: " + address1);  // Add a print statement to check the Address object

        // Create an Employee object with the Address
        Employee employee1 = new Employee("John", "Doe", address1);
        System.out.println("Employee Address: " + employee1.getAddress());  

        // Save the employee
        employeeDAO.saveEmployee(employee1);

        // Ensure the Employee ID is set
        Assert.assertNotNull("Employee ID should be set after saving", employee1.getEmployeeID());

        // Fetch the employee back from the database
        Employee savedEmployee = employeeDAO.getEmployeeById(employee.getEmployeeID());

        // Assert that the Employee and Address were saved correctly
        Assert.assertNotNull("Saved Employee ID should not be null", savedEmployee.getEmployeeID());
        Assert.assertEquals("Employee's first name should match", "John", savedEmployee.getFirstName());
        Assert.assertEquals("Employee's last name should match", "Doe", savedEmployee.getLastName());
        Assert.assertNotNull("Employee's address should not be null", savedEmployee.getAddress());
        Assert.assertEquals("Employee's address street should match", "123 Elm St", savedEmployee.getAddress().getStreet());
    }

    @Test
    public void testLoadEmployee() {
        employeeDAO.saveEmployee(employee);
        Employee loadedEmployee = employeeDAO.loadEmployee(employee.getEmployeeID());  // TAG: Hibernate load
        assertEquals(employee.getFirstName(), loadedEmployee.getFirstName());
    }

    @Test
    public void testQueryEmployeeByName() {
        employeeDAO.saveEmployee(employee);
        assertTrue(employeeDAO.queryEmployeeByName("John").size() > 0);  // TAG: Hibernate query
    }

    @Test
    public void testScrollableIteration() {
        employeeDAO.iterateEmployees();  // TAG: Hibernate scrollable iteration
    }

    @Test
    public void testPagination() {
        employeeDAO.saveEmployee(employee);
        assertTrue(employeeDAO.paginateEmployees(1, 10).size() > 0);  // TAG: Hibernate pagination
    }

    @Test
    public void testUpdateEmployee() {
        employeeDAO.saveEmployee(employee);
        employee.setFirstName("Updated");
        employeeDAO.updateEmployee(employee);  // TAG: Hibernate flush
        Employee updatedEmployee = employeeDAO.loadEmployee(employee.getEmployeeID());
        assertEquals("Updated", updatedEmployee.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        employeeDAO.saveEmployee(employee);
        employeeDAO.deleteEmployee(employee);  // TAG: Hibernate delete
        assertNull(employeeDAO.loadEmployee(employee.getEmployeeID()));
    }

    @After
    public void tearDown() {
        employeeDAO = null;
        employee = null;
    }
}
