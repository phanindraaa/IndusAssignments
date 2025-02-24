package com.indus.training.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
    
    // Database credentials (use the default master database to create a new one)
    private static final String DB_URL = "jdbc:sqlserver://phani\\SQLEXPRESS;databaseName=master;portNumber=1433;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "phani";
    private static final String PASS = "HUNter@143";
    
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
            
          
            // Step 2: Use the new database
            String sqlUseDB = "USE EmployeeDb";
            stmt.executeUpdate(sqlUseDB);
            
            // Step 3: Create an Employees table
            String sqlCreateTable = "CREATE TABLE Employees (" +
                    "id INT PRIMARY KEY," +
                    "name NVARCHAR(100) NOT NULL," +
                    "phone NVARCHAR(15) NOT NULL," +
                    "email NVARCHAR(100) NOT NULL," +
                    "address NVARCHAR(255) NOT NULL)";
            stmt.executeUpdate(sqlCreateTable);
            System.out.println("Table Employees created successfully.");
//            
//            // Step 4: Insert 3 to 5 records into the Employees table
//            String sqlInsertData = "INSERT INTO Employees (name, phone, email, address) VALUES " +
//                    "('Venkata', '123-456-7890', 'venkata@gmail.com', 'Dayton')," +
//                    "('Sai', '987-654-3210', 'sai@gmail.com', 'Fairborn')," +
//                    "('Phani', '999-777-3333', 'phani@gmail.com', 'Miamisburg')";
//            
//            stmt.executeUpdate(sqlInsertData);
            System.out.println("Records inserted into Employees table successfully.");
            
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
