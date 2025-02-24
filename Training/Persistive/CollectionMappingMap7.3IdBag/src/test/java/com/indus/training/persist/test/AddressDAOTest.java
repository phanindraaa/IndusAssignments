package com.indus.training.persist.test;

import com.indus.training.persist.dao.AddressDao;
import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class AddressDAOTest {

    private static SessionFactory sessionFactory;
    private static AddressDao addressDao;
    private static EmployeeDAO employeeDao;

    @BeforeClass
    public static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        addressDao = new AddressDao();
        employeeDao = new EmployeeDAO();
    }

    @AfterClass
    public static void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void testIdbagMapping() {
        // Create Address and Employees
        Address address = new Address("123 Main St", "New York", "USA");
        addressDao.saveAddress(address);
        
        // Ensure address ID is set
        assertNotNull("Address ID should not be null", address.getAddressID());

        Employee emp1 = new Employee("John", "Doe", address);
        Employee emp2 = new Employee("Jane", "Smith", address);

        // Save Employees
        employeeDao.saveEmployee(emp1);
        employeeDao.saveEmployee(emp2);

        // Ensure employee IDs are set
        assertNotNull("Employee ID should not be null", emp1.getEmployeeID());
        assertNotNull("Employee ID should not be null", emp2.getEmployeeID());

        // Fetch Address and associated Employees
        Address savedAddress = addressDao.getAddressById(address.getAddressID());
        assertNotNull(savedAddress);
        assertEquals("123 Main St", savedAddress.getStreet());

        Map<Long, Employee> employees = savedAddress.getEmployees();
        assertNotNull(employees);
        assertEquals(2, employees.size());

        Employee savedEmp1 = employees.get(emp1.getEmployeeID());
        Employee savedEmp2 = employees.get(emp2.getEmployeeID());

        assertNotNull(savedEmp1);
        assertEquals("John", savedEmp1.getFirstName());

        assertNotNull(savedEmp2);
        assertEquals("Jane", savedEmp2.getFirstName());
    }


    @Test
    public void testDeleteEmployeeAndCheckAddress() {
        // Create Address and Employee
        Address address = new Address("456 Park Ave", "Los Angeles", "USA");
        Employee emp = new Employee("Alice", "Williams", address);

        // Save Address and Employee
        addressDao.saveAddress(address);
        employeeDao.saveEmployee(emp);

        // Delete Employee
        employeeDao.deleteEmployee(emp.getEmployeeID());

        // Fetch Address and verify the Employee is removed
        Address savedAddress = addressDao.getAddressById(address.getAddressID());
        assertNotNull(savedAddress);

        Map<Long, Employee> employees = savedAddress.getEmployees();
        assertTrue(employees.isEmpty());
    }
}
