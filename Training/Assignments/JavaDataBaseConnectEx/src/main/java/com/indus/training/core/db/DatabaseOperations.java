package com.indus.training.core.db;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseOperations {
    
    private static String DB_URL;
    private static String USER;
    private static String PASS;
    
    static {
        try (InputStream input = DatabaseOperations.class.getClassLoader().getResourceAsStream("configs/dbconfig.properties")) {
            if (input == null) {
                throw new FileNotFoundException("Sorry, unable to find dbconfig.properties");
            }
            
            // Load properties file
            Properties prop = new Properties();
            prop.load(input);
            
            // Get the property values
            DB_URL = prop.getProperty("db.url");
            USER = prop.getProperty("db.user");
            PASS = prop.getProperty("db.pass");
            
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        
        try {
            // Register JDBC driver (optional step for newer JDBC versions)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Open a connection
            System.out.println("Connecting to SQL Server...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            
            System.out.println("Connected to SQL Server database successfully.");
            
            // Create a statement object
            stmt = connection.createStatement();
            
            // Step 1: Insert a single record into the Employees table
            String sqlInsert = "INSERT INTO Employees (name, phone, email, address) VALUES " +
                               "('teja', '234-567-8901', 'teja@gmail.com', 'MiddleTown')";
            stmt.executeUpdate(sqlInsert);
            System.out.println("Record inserted into Employees table successfully.");
            
            // Step 2: Select and print the inserted record
            String sqlSelect = "SELECT id, name, phone, email, address FROM Employees WHERE name='teja'";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Address: " + rs.getString("address"));
            }
            rs.close();
            
            // Step 3: Update the inserted record
            String sqlUpdate = "UPDATE Employees SET address='Mason' WHERE name='teja'";
            stmt.executeUpdate(sqlUpdate);
            System.out.println("Record updated successfully.");
            
            // Step 4: Delete the inserted record
            String sqlDelete = "DELETE FROM Employees WHERE name='teja'";
            stmt.executeUpdate(sqlDelete);
            System.out.println("Record deleted successfully.");
            
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        
        System.out.println("Goodbye!");
    }
}
