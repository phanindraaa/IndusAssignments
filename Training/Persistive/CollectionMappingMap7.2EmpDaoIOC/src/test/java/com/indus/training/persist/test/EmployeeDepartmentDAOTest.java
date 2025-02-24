package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeDepartmentDAO;
import com.indus.training.persist.entity.EmployeeDepartment;
import com.indus.training.persist.entity.EmployeeDepartmentId;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeDepartmentDAOTest {

    private EmployeeDepartmentDAO dao;
    private EmployeeDepartment testEmployeeDepartment;
    private EmployeeDepartmentId testId;

    @Before
    public void setUp() {
        dao = new EmployeeDepartmentDAO();
        // Create dynamic test IDs and data
        long employeeID = System.currentTimeMillis(); // Use current time for uniqueness
        long departmentID = employeeID + 1; // Ensure departmentID is different

        testId = new EmployeeDepartmentId(employeeID, departmentID);
        testEmployeeDepartment = new EmployeeDepartment();
        testEmployeeDepartment.setId(testId); // Set the composite key (EmployeeDepartmentId)
    }

    @After
    public void tearDown() {
        // Clean up resources, if necessary
        dao = null;
        testId = null;
        testEmployeeDepartment = null;
    }

    @Test
    public void testSave() {
        dao.save(testEmployeeDepartment);
        EmployeeDepartment retrieved = dao.findById(testId);
        assertNotNull(retrieved);
        // You might want to check specific fields of the retrieved entity
    }

    @Test
    public void testFindById() {
        dao.save(testEmployeeDepartment);
        EmployeeDepartment retrieved = dao.findById(testId);
        assertNotNull(retrieved);
        // You might want to check specific fields of the retrieved entity
    }

    @Test
    public void testUpdate() {
        dao.save(testEmployeeDepartment);
        EmployeeDepartment retrieved = dao.findById(testId);
        assertNotNull(retrieved);
        // Update testEmployeeDepartment fields as necessary
        // Example: retrieved.setSomeField("Updated Value");
        dao.update(retrieved);
        EmployeeDepartment updated = dao.findById(testId);
        assertNotNull(updated);
        // Check for updated fields here
    }

    @Test
    public void testDelete() {
        dao.save(testEmployeeDepartment);
        dao.delete(testId);
        EmployeeDepartment retrieved = dao.findById(testId);
        assertNull(retrieved);
    }
    
    @Test
    public void testInsert() {
    	
    }
}
