package com.indus.training.persist.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.indus.training.persist.dac.impl.EmpDataDb;
import com.indus.training.persist.entity.EmpDetails;
import com.indus.training.persist.exception.EmpDataException;

import junit.framework.TestCase;


public class testEmpDataDb extends TestCase{

    private EmpDataDb empData;
    private Connection connection;

    public void setUp() throws SQLException, EmpDataException {
        // Initialize EmpData with null values
        String configFilePath = testEmpDataDb.class.getClassLoader().getResource("dbconfig.properties").getPath();

        // Initialize database connection
        empData = new EmpDataDb(configFilePath);

        // Ensure the database is clean before tests
        cleanDatabase();
    }

    public void tearDown() throws SQLException {
        // Clean up the database after tests
        cleanDatabase();
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void testInsertEmployee() throws IOException {
        try {
            EmpDetails empDetails = new EmpDetails();
            empDetails.setEmpId(4);
            empDetails.setEmpName("forsai");
            empDetails.setEmpPhone("456123");
            empDetails.setEmpEmail("saiiii@gmail.com");
            empDetails.setEmpAddress("Some Address"); // Assuming EmpDetails has an address field
            boolean insert = empData.insertEmployee(empDetails);

            // Fetch the inserted employee to verify
            EmpDetails fetchedEmpDetails = empData.fetchEmpDetails(empDetails.getEmpId());
            assertNotNull("Employee should be inserted", fetchedEmpDetails);
            assertEquals("Employee ID should match", empDetails.getEmpId(), fetchedEmpDetails.getEmpId());
            assertEquals("Employee Name should match", empDetails.getEmpName(), fetchedEmpDetails.getEmpName());
        } catch (EmpDataException | SQLException e) {
            e.printStackTrace();
            fail("Exception occurred while testing insert operation: " + e.getMessage());
        }
    }

    public void testUpdateEmployee() throws IOException {
        try {
            // First, insert an employee
            EmpDetails empDetails2 = new EmpDetails();
            empDetails2.setEmpId(3);
            empDetails2.setEmpName("treesai");
            empDetails2.setEmpPhone("345612");
            empDetails2.setEmpEmail("saiii@gmail.com");
            empDetails2.setEmpAddress("Old Address"); // Assuming EmpDetails has an address field
            boolean insert = empData.insertEmployee(empDetails2);
            // Update the employee details
            empDetails2.setEmpName("Jane Doe");
            empDetails2.setEmpAddress("New Address"); // Assuming EmpDetails has an address field
            boolean update = empData.updateEmployee(empDetails2);
            // Fetch the updated employee to verify
            EmpDetails updatedEmpDetails = empData.fetchEmpDetails(empDetails2.getEmpId());
            assertNotNull("Employee should be updated", updatedEmpDetails);
            assertEquals("Updated Employee Name should match", empDetails2.getEmpName(), updatedEmpDetails.getEmpName());
            assertEquals("Updated Employee Address should match", empDetails2.getEmpAddress(), updatedEmpDetails.getEmpAddress()); // Assuming EmpDetails has an address field
        } catch (EmpDataException | SQLException e) {
            e.printStackTrace();
            fail("Exception occurred while testing update operation: " + e.getMessage());
        }
    }

    public void testFetchEmployee() throws IOException {
        try {
            // Insert an employee
            EmpDetails empDetails1 = new EmpDetails();
            empDetails1.setEmpId(2);
            empDetails1.setEmpName("tosai");
            empDetails1.setEmpPhone("234561");
            empDetails1.setEmpEmail("saii@gmail.com");
            empDetails1.setEmpAddress("Some Address"); // Assuming EmpDetails has an address field
            boolean insert = empData.insertEmployee(empDetails1);

            // Fetch the employee details
            EmpDetails fetchedEmpDetails = empData.fetchEmpDetails(empDetails1.getEmpId());
            assertNotNull("Employee should be fetched", fetchedEmpDetails);
            assertEquals("Employee Name should match", empDetails1.getEmpName(), fetchedEmpDetails.getEmpName());
            assertEquals("Employee Address should match", empDetails1.getEmpAddress(), fetchedEmpDetails.getEmpAddress()); // Assuming EmpDetails has an address field
        } catch (EmpDataException | SQLException e) {
            e.printStackTrace();
            fail("Exception occurred while testing fetch operation: " + e.getMessage());
        }
    }

    public void testDeleteEmployee() {
        try {
            // Insert an employee
            EmpDetails empDetails = new EmpDetails();
            empDetails.setEmpId(1);
            empDetails.setEmpName("sai");
            empDetails.setEmpPhone("123456");
            empDetails.setEmpEmail("sai@gmail.com");
            empDetails.setEmpAddress("Some Address"); // Assuming EmpDetails has an address field
            boolean insert = empData.insertEmployee(empDetails);

            // Delete the employee
            boolean delete = empData.deleteEmployee(empDetails.getEmpId());
            // Try fetching the deleted employee
           assertTrue( delete);
        } catch (EmpDataException e) {
            e.printStackTrace();
            fail("Exception occurred while testing delete operation: " + e.getMessage());
        }
    }

    private void cleanDatabase() throws SQLException {
        // Clean the test database before and after tests
        if (connection != null && !connection.isClosed()) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate("DELETE FROM Employees WHERE id IN (1, 2, 3, 4)"); // Adjust as necessary
            }
        }
    }
}
