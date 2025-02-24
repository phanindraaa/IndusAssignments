package com.indus.training.persist.test;

import com.indus.training.persist.dao.AddressDao;
import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressDAOTest {

    private AddressDao addressDAO;
    private EmployeeDAO employeeDAO;
    private Address testAddress;
    private Employee testEmployee;

    @Before
    public void setUp() {
        addressDAO = new AddressDao();
        employeeDAO = new EmployeeDAO();
    }

    @Test
    public void testSaveAddressWithEmployee() {
        // Step 1: Create Address
        Address address = new Address("123 Main St", "New York", "USA");

        // Step 2: Create Employee and associate it with the Address
        Employee employee = new Employee("John", "Doe", address);
        address.setEmployee(employee);  // Set the employee in the address entity
        
        // Step 3: Save Address and Employee (due to cascading, employee should also be saved)
        addressDAO.saveAddress(address);
        
        // Check that the Address and Employee were saved
        assertNotNull("Address ID should not be null", address.getAddressID());
        assertNotNull("Employee ID should not be null", employee.getEmployeeID());

        // Step 4: Fetch the saved Address and verify One-to-One relationship
        Address savedAddress = addressDAO.getAddressById(address.getAddressID());
        assertNotNull("Saved Address should not be null", savedAddress);
        assertNotNull("Associated Employee should not be null", savedAddress.getEmployee());
        assertEquals("Employee first name should match", "John", savedAddress.getEmployee().getFirstName());
    }

    @Test
    public void testGetEmployeeByAddressId() {
        // Step 1: Create and save Address
        Address address = new Address("456 Market St", "San Francisco", "USA");
        Employee employee = new Employee("Jane", "Smith", address);
        address.setEmployee(employee);  // Set the employee in the address entity
        addressDAO.saveAddress(address);

        // Step 2: Fetch Address and verify the associated Employee
        Address savedAddress = addressDAO.getAddressById(address.getAddressID());
        assertNotNull("Saved Address should not be null", savedAddress);
        assertNotNull("Associated Employee should not be null", savedAddress.getEmployee());
        assertEquals("Employee first name should match", "Jane", savedAddress.getEmployee().getFirstName());
        assertEquals("Employee last name should match", "Smith", savedAddress.getEmployee().getLastName());
    }

    @After
    public void tearDown() {
        if (testEmployee != null && testEmployee.getEmployeeID() != null) {
            employeeDAO.deleteEmployee(testEmployee.getEmployeeID());
        }
        if (testAddress != null && testAddress.getAddressID() != null) {
            addressDAO.deleteAddress(testAddress.getAddressID());
        }
        addressDAO = null;
        employeeDAO = null;
    }
}
