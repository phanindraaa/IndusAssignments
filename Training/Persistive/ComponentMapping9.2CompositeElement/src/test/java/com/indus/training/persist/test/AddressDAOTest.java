package com.indus.training.persist.test;

import com.indus.training.persist.dao.AddressDao;
import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

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
    public void testCompositeElementMapping() {
        // Step 1: Save the address first
        Address address = new Address("456 Market St", "San Francisco", "USA");
        addressDAO.saveAddress(address);
        
        // Step 2: Create and associate employees with the address
        Employee employee1 = new Employee("John", "Doe", address);
        Employee employee2 = new Employee("Jane", "Smith", address);
        
        employeeDAO.saveEmployee(employee1);
        employeeDAO.saveEmployee(employee2);
        
        // Step 3: Retrieve the address and verify the employees are mapped correctly
        Set<Employee> employees = addressDAO.getEmployeesByAddressId(address.getAddressID());
        assertNotNull(employees);
        assertEquals(2, employees.size());  // Check that two employees are associated with the address
        
        // Verify employee details
      
    }

    @After
    public void tearDown() {
        addressDAO = null;
        employeeDAO = null;
    }
}
