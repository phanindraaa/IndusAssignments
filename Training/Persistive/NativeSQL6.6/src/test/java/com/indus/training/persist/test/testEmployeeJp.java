package com.indus.training.persist.test;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.indus.training.persist.dao.EmployeeManagerJpa;
import com.indus.training.persist.entity.Employees;
import com.indus.training.persist.util.JpaUtil;

public class testEmployeeJp {
    
    private static EmployeeManagerJpa employeeManager;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	employeeManager = new EmployeeManagerJpa();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        JpaUtil.shutdown();
    }

    @Test
    public void testInsert() {
        employeeManager.insert(1, "venkata", "12345", "venkata@gmail.com", "Columbus");
        Employees employee = employeeManager.fetch(1);
        assertNotNull("Employee should be inserted", employee);
        assertEquals("Employee name should match", "Alice Johnson", employee.getName());
    }

    @Test
    public void testFetch() {
        Employees employee = employeeManager.fetch(1);
        assertNotNull("Employee should exist", employee);
        assertEquals("Phone number should match", "12345", employee.getPhone());
    }

    @Test
    public void testUpdate() {
        employeeManager.update(1, "venkatasai", "1234567", "venkata@gmail.com", "Columbus");
        Employees employee = employeeManager.fetch(1);
        assertEquals("Updated name should match", "venkatasai", employee.getName());
        assertEquals("Updated phone number should match", "1234567", employee.getPhone());
    }

    @Test
    public void testDelete() {
        employeeManager.delete(1);
        Employees employee = employeeManager.fetch(1);
        assertNull("Employee should be deleted", employee);
    }
}
