package com.indus.training.persist.test;
import junit.framework.TestCase;

import com.indus.training.persist.entity.Employees;
import com.indus.training.persist.impl.EmployeeManager;

public class testEemployee extends TestCase {

    private EmployeeManager empManager;

    protected void setUp() {
        empManager = new EmployeeManager();
    }

    public void testInsert() {
        empManager.insert(1, "Alice", "98765", "alice@gmail.com", "Boston");
        Employees emp = empManager.fetch(1);
        assertNotNull(emp);
        assertEquals("Alice", emp.getName());
    }

    public void testUpdate() {
        empManager.insert(2, "Bob", "12345", "bob@gmail.com", "New York");
        empManager.update(2, "Bobby", "54321", "bobby@gmail.com", "San Francisco");
        Employees emp = empManager.fetch(2);
        assertNotNull(emp);
        assertEquals("Bobby", emp.getName());
    }

    public void testFetch() {
        empManager.insert(3, "Charlie", "11111", "charlie@gmail.com", "Los Angeles");
        Employees emp = empManager.fetch(3);
        assertNotNull(emp);
        assertEquals("Charlie", emp.getName());
    }

    public void testDelete() {
        empManager.insert(4, "David", "22222", "david@gmail.com", "Chicago");
        empManager.delete(4);
        Employees emp = empManager.fetch(4);
        assertNull(emp);
    }

    protected void tearDown() {
        empManager = null;
    }
}
