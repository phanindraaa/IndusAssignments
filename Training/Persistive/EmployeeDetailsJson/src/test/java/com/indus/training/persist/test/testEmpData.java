package com.indus.training.persist.test;

import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import com.indus.training.persist.dao.impl.EmpData;
import com.indus.training.persist.entity.EmpDetails;
import com.indus.training.persist.exception.EmpDataException;

public class testEmpData extends TestCase {

    private EmpData empData;
    private EmpDetails empDetails;

    protected void setUp() throws Exception {
        super.setUp();
        empData = new EmpData();
        empDetails = new EmpDetails();
        
        empDetails.setEmpId(1);
        empDetails.setEmpName("John Doe");
        empDetails.setEmpPhone("1234567890");
        empDetails.setEmpEmail("johndoe@example.com");

        // Ensure the directory exists before running tests
        createEmployeeFilesDirectory();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        // Clean up created files after each test
        File file = new File(getEmployeeFilePath(empDetails.getEmpId()));
        if (file.exists()) {
            file.delete();
        }
    }

    private void createEmployeeFilesDirectory() {
        String currentDir = System.getProperty("user.dir");
        File directory = new File(currentDir, "EmployeeFiles");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private String getEmployeeFilePath(int empId) {
        String currentDir = System.getProperty("user.dir");
        return currentDir + "/EmployeeFiles/Employee_" + empId + ".json";
    }

    public void testInsertEmployee() throws IOException, EmpDataException {
        boolean result = empData.insertEmployee(empDetails);
        assertTrue(result);

        // Verify that the file was created
        File file = new File(getEmployeeFilePath(empDetails.getEmpId()));
        assertTrue(file.exists());
    }

    public void testInsertEmployee_FileAlreadyExists() {
        try {
            // Insert the employee once
            empData.insertEmployee(empDetails);

            // Attempt to insert the same employee again, should throw an exception
            empData.insertEmployee(empDetails);
            fail("Expected EmpDataException not thrown");
        } catch (EmpDataException e) {
            assertEquals("File already exists for Employee ID: " + empDetails.getEmpId(), e.getMessage());
        }
    }

    public void testFetchEmployeeDetails() throws IOException, EmpDataException {
        // First insert the employee
        empData.insertEmployee(empDetails);

        EmpDetails fetchedDetails = empData.fetchEmpDetails(empDetails.getEmpId());
        assertNotNull(fetchedDetails);
        assertEquals(empDetails.getEmpId(), fetchedDetails.getEmpId());
        assertEquals(empDetails.getEmpName(), fetchedDetails.getEmpName());
        assertEquals(empDetails.getEmpPhone(), fetchedDetails.getEmpPhone());
        assertEquals(empDetails.getEmpEmail(), fetchedDetails.getEmpEmail());
    }

    public void testUpdateEmployee() throws IOException, EmpDataException {
        // First insert the employee
        empData.insertEmployee(empDetails);

        // Update details
        empDetails.setEmpName("Jane Doe");
        empDetails.setEmpPhone("9876543210");
        empDetails.setEmpEmail("janedoe@example.com");

        boolean result = empData.updateEmployee(empDetails);
        assertTrue(result);

        EmpDetails updatedDetails = empData.fetchEmpDetails(empDetails.getEmpId());
        assertEquals("Jane Doe", updatedDetails.getEmpName());
        assertEquals("9876543210", updatedDetails.getEmpPhone());
        assertEquals("janedoe@example.com", updatedDetails.getEmpEmail());
    }

    public void testDeleteEmployee() throws IOException, EmpDataException {
        // First insert the employee
        empData.insertEmployee(empDetails);

        boolean result = empData.deleteEmployee(empDetails.getEmpId());
        assertTrue("Employee should be deleted successfully", result);

        File file = new File(getEmployeeFilePath(empDetails.getEmpId()));
        assertFalse(file.exists());
    }
}
