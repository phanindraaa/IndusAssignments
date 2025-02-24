package com.indus.training.persist.test;

import com.indus.training.persist.dao.AddressDao;
import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class AddressDAOTest {

    private AddressDao addressDAO;
    private EmployeeDAO employeeDAO;
    private Address testAddress;
    private Long addressId;

    @Before
    public void setUp() {
        addressDAO = new AddressDao();
        employeeDAO = new EmployeeDAO();
    }

    @Test
    public void testSaveAddress() {
        // Step 1: Create and save the address
        testAddress = new Address("123 Main St", "New York", "USA");
        addressDAO.saveAddress(testAddress);
        
        // Step 2: Verify that the address was saved and has a valid ID
        addressId = testAddress.getAddressID();
        assertNotNull("Address ID should not be null after saving", addressId);
    }

    @Test
    public void testGetAddressById() {
        // Step 1: Save the address
        testAddress = new Address("456 Market St", "San Francisco", "USA");
        addressDAO.saveAddress(testAddress);

        // Step 2: Retrieve the address by ID
        Address retrievedAddress = addressDAO.getAddressById(testAddress.getAddressID());
        assertNotNull("Address should be retrieved", retrievedAddress);
        assertEquals("Street should match", "456 Market St", retrievedAddress.getStreet());
        assertEquals("City should match", "San Francisco", retrievedAddress.getCity());
        assertEquals("Country should match", "USA", retrievedAddress.getCountry());
    }

    @Test
    public void testGetEmployeesByAddressId() {
        // Step 1: Create and save an address
        Address address = new Address("789 Broadway", "New York", "USA");
        addressDAO.saveAddress(address);
        
        // Step 2: Create and save employees associated with the address
        Employee employee1 = new Employee("John", "Doe", address);
        Employee employee2 = new Employee("Jane", "Smith", address);
        
        employeeDAO.saveEmployee(employee1);
        employeeDAO.saveEmployee(employee2);
        
        // Step 3: Retrieve employees by the address ID
        Map<Long, Employee> employees = addressDAO.getEmployeesByAddressId(address.getAddressID());
        
        assertNotNull("Employees should be retrieved", employees);
        assertEquals("Two employees should be associated with the address", 2, employees.size());
        
        // Step 4: Verify the details of the first employee
        Employee retrievedEmployee1 = employees.get(employee1.getEmployeeID());
        assertNotNull("First employee should be retrieved", retrievedEmployee1);
        assertEquals("First employee's first name should match", "John", retrievedEmployee1.getFirstName());
        
        // Step 5: Verify the details of the second employee
        Employee retrievedEmployee2 = employees.get(employee2.getEmployeeID());
        assertNotNull("Second employee should be retrieved", retrievedEmployee2);
        assertEquals("Second employee's first name should match", "Jane", retrievedEmployee2.getFirstName());
    }

    @Test
    public void testDeleteAddress() {
        // Step 1: Create and save an address
        Address address = new Address("101 Wall St", "New York", "USA");
        addressDAO.saveAddress(address);
        Long addressId = address.getAddressID();
        
        // Step 2: Delete the address
        addressDAO.deleteAddress(addressId);
        
        // Step 3: Verify that the address was deleted
        Address deletedAddress = addressDAO.getAddressById(addressId);
        assertNull("Address should be null after deletion", deletedAddress);
    }

    @After
    public void tearDown() {
        if (addressId != null) {
            addressDAO.deleteAddress(addressId); // Cleanup
        }
        addressDAO = null;
        employeeDAO = null;
    }
}
