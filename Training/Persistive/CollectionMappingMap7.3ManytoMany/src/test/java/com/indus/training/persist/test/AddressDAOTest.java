package com.indus.training.persist.test;

import com.indus.training.persist.dao.AddressDao;
import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.HashSet;

import static org.junit.Assert.*;

public class AddressDAOTest {

    private AddressDao addressDAO;
    private EmployeeDAO employeeDAO;

    @Before
    public void setUp() {
        addressDAO = new AddressDao();
        employeeDAO = new EmployeeDAO();
    }

    @Test
    public void testSaveAddress() {
        Address address = new Address("123 Main St", "New York", "USA");
        addressDAO.saveAddress(address);
        assertNotNull(address.getAddressID());
    }

    @Test
    public void testGetEmployeesByAddressId() {
        // Step 1: Save the address first
        Address address = new Address("456 Market St", "San Francisco", "USA");
        addressDAO.saveAddress(address);
        
        // Step 2: Create and associate employees with the address
        Employee employee1 = new Employee("John", "Doe");
        Employee employee2 = new Employee("Jane", "Smith");
        
        employee1.getAddresses().add(address);
        employee2.getAddresses().add(address);
        
        employeeDAO.saveEmployee(employee1);
        employeeDAO.saveEmployee(employee2);

        // Step 3: Retrieve employees by address ID
        Set<Employee> employees = addressDAO.getEmployeesByAddressId(address.getAddressID());

        // Verify employees are correctly associated
        assertNotNull(employees);
        assertEquals(2, employees.size());
        
        Set<String> lastNames = new HashSet<>();
        for (Employee emp : employees) {
            lastNames.add(emp.getLastName());
        }
        
        // Check that the last names match the expected values
        assertTrue(lastNames.contains("Doe"));
        assertTrue(lastNames.contains("Smith"));
    }

    @After
    public void tearDown() {
        addressDAO = null;
        employeeDAO = null;
    }
}
