package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    private EmployeeDAO employeeDao;
    private Session session;

    @Before
    public void setUp() {
        employeeDao = new EmployeeDAO();
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @After
    public void tearDown() {
        if (session != null) {
            session.close();
        }
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("Anytown");
        address.setCountry("Country");
        employee.setAddress(address);

        employeeDao.saveEmployee(employee);
        
        // Verify employee was saved
        Employee retrievedEmployee = employeeDao.getEmployee(employee.getEmployeeID());
        assertNotNull(retrievedEmployee);
        assertEquals("John", retrievedEmployee.getFirstName());
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Jane");
        employee.setLastName("Doe");
        employeeDao.saveEmployee(employee);
        
        employee.setFirstName("Janet");
        employeeDao.updateEmployee(employee);

        Employee updatedEmployee = employeeDao.getEmployee(employee.getEmployeeID());
        assertEquals("Janet", updatedEmployee.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Mark");
        employee.setLastName("Smith");
        employeeDao.saveEmployee(employee);
        
        employeeDao.deleteEmployee(employee.getEmployeeID());

        Employee deletedEmployee = employeeDao.getEmployee(employee.getEmployeeID());
        assertNull(deletedEmployee);
    }

    @Test
    public void testGetEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Lucy");
        employee.setLastName("Brown");
        employeeDao.saveEmployee(employee);
        
        Employee retrievedEmployee = employeeDao.getEmployee(employee.getEmployeeID());
        assertNotNull(retrievedEmployee);
        assertEquals("Lucy", retrievedEmployee.getFirstName());
    }
}
