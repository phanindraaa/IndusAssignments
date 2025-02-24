package com.indus.training.persist.test;

import com.indus.training.persist.dao.AddressDao;
import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class AddressDaoTest {

    private AddressDao addressDAO;
    private EmployeeDAO employeeDAO;

    @Before
    public void setUp() {
        addressDAO = new AddressDao();
        employeeDAO = new EmployeeDAO();
    }

    @Test
    public void testSaveAndRetrieveAddressWithEmployees() {
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("New York");
        address.setCountry("USA");

        SortedSet<Employee> employees = new TreeSet<>(new Employee.LastNameComparator());
        employees.add(new Employee("John", "Doe", address));
        employees.add(new Employee("Jane", "Smith", address));

        address.setEmployees(employees);
        addressDAO.saveAddress(address);

        Address retrievedAddress = addressDAO.getAddressById(address.getAddressID());

        assertNotNull(retrievedAddress);
        assertEquals(2, retrievedAddress.getEmployees().size());  // Ensure two employees are saved

        Employee firstEmployee = retrievedAddress.getEmployees().first();
        Employee lastEmployee = retrievedAddress.getEmployees().last();

        assertEquals("Doe", firstEmployee.getLastName());
        assertEquals("Smith", lastEmployee.getLastName());
    }
    
    @Test
    public void testSaveEmployeeWithAddress() {
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("New York");
        address.setCountry("USA");

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setAddress(address);  // Link the employee to the address

        employeeDAO.saveEmployeeWithAddress(employee);  // Use the new DAO method

        // Now retrieve the saved employee
        Employee retrievedEmployee = employeeDAO.getEmployeeById(employee.getEmployeeID());

        assertNotNull(retrievedEmployee);
        assertEquals("John", retrievedEmployee.getFirstName());
        assertEquals("123 Main St", retrievedEmployee.getAddress().getStreet());  // Ensure address was saved
    }


    @After
    public void tearDown() {
        addressDAO = null;
    }
}
