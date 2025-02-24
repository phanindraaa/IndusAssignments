package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeManager;
import com.indus.training.persist.entity.Employees;
import com.indus.training.persist.exception.EmployeeException;
import com.indus.training.persist.util.MyBatisUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class testEmployeeMybatis {
    
    private EmployeeManager employeeManager;

    @Before
    public void setUp() {
        employeeManager = new EmployeeManager();
    }

    @After
    public void tearDown() {    	
    }

    @Test
    public void testInsertEmployee() throws EmployeeException {
        Employees emp = new Employees();
        emp.setId(1);
        emp.setName("Venkata");
        emp.setPhone("123456");
        emp.setEmail("venkata@gmail.com");
        emp.setAddress("Columbus");

        // Insert employee
        employeeManager.insertEmployee(emp);

        // Fetch the inserted employee to verify
        Employees fetchedEmp = employeeManager.fetchEmployee(1);
        assertNotNull(fetchedEmp);
        assertEquals("Venkata", fetchedEmp.getName());
        assertEquals("123456", fetchedEmp.getPhone());
        assertEquals("venkata@gmail.com", fetchedEmp.getEmail());
        assertEquals("Columbus", fetchedEmp.getAddress());
    }

    @Test
    public void testFetchEmployee() throws EmployeeException {
        // Insert a test employee
        Employees emp = new Employees();
        emp.setId(2);
        emp.setName("Sai");
        emp.setPhone("7890123");
        emp.setEmail("sai@gmail.com");
        emp.setAddress("Dayton");

        employeeManager.insertEmployee(emp);

        // Fetch the employee and verify the details
        Employees fetchedEmp = employeeManager.fetchEmployee(2);
        assertNotNull(fetchedEmp);
        assertEquals("Sai", fetchedEmp.getName());
        assertEquals("7890123", fetchedEmp.getPhone());
        assertEquals("sai@gmail.com", fetchedEmp.getEmail());
        assertEquals("Dayton", fetchedEmp.getAddress());
    }

    @Test
    public void testUpdateEmployee() throws EmployeeException {
        // Insert a test employee
        Employees emp = new Employees();
        emp.setId(3);
        emp.setName("teja");
        emp.setPhone("09876543");
        emp.setEmail("teja@gmail.com");
        emp.setAddress("Cincinnati");

        employeeManager.insertEmployee(emp);

        // Update the employee's details
        emp.setName("Raviteja");
        emp.setPhone("09876543");
        emp.setEmail("rteja@gmail.com.com");
        emp.setAddress("Mason");

        employeeManager.updateEmployee(emp);

        // Fetch the updated employee and verify the details
        Employees updatedEmp = employeeManager.fetchEmployee(3);
        assertNotNull(updatedEmp);
        assertEquals("Raviteja", updatedEmp.getName());
        assertEquals("09876543", updatedEmp.getPhone());
        assertEquals("Mason", updatedEmp.getAddress());
    }

    @Test
    public void testDeleteEmployee() throws EmployeeException {
        // Insert a test employee
        Employees emp = new Employees();
        emp.setId(4);
        emp.setName("phani");
        emp.setPhone("9876543");
        emp.setEmail("phani@gmail.com");
        emp.setAddress("Springboro");

        employeeManager.insertEmployee(emp);

        // Delete the employee
        employeeManager.deleteEmployee(4);

        // Try to fetch the deleted employee (should be null)
        Employees deletedEmp = employeeManager.fetchEmployee(4);
        assertNull(deletedEmp);
    }
}
