package com.indus.training.persist.dac.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.indus.training.persist.dac.IEmpData;
import com.indus.training.persist.entity.EmpDetails;
import com.indus.training.persist.exception.EmpDataException;

public class EmpDataDb implements IEmpData {

    private Connection dbConnection;
    private Properties dbProperties;

    // Constructor with configuration file path
    public EmpDataDb(String configFilePath) throws EmpDataException {
        this.dbProperties = loadProperties(configFilePath);
        this.dbConnection = establishConnection();
    }

    // Default constructor, use default config path
    public EmpDataDb() throws EmpDataException {
        String defaultConfigPath = "src/main/resources/dbconfig.properties";
        this.dbProperties = loadProperties(defaultConfigPath);
        this.dbConnection = establishConnection();
    }

    // Method to load properties from the configuration file
    private Properties loadProperties(String configFilePath) throws EmpDataException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            props.load(fis);
        } catch (IOException e) {
            throw new EmpDataException("Error loading database configuration", e);
        }
        return props;
    }

    // Method to establish the database connection
    private Connection establishConnection() throws EmpDataException {
        String url = dbProperties.getProperty("db.url");
        String user = dbProperties.getProperty("db.user");
        String password = dbProperties.getProperty("db.pass");

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new EmpDataException("Error establishing database connection", e);
        }
    }

    @Override
    public boolean insertEmployee(EmpDetails empInfo) throws EmpDataException {
        String tableName = dbProperties.getProperty("db.table.name");
        String columnId = dbProperties.getProperty("db.column.id");
        String columnName = dbProperties.getProperty("db.column.name");
        String columnPhone = dbProperties.getProperty("db.column.phone");
        String columnEmail = dbProperties.getProperty("db.column.email");
        String columnAddress = dbProperties.getProperty("db.column.address");

        String sql = "INSERT INTO " + tableName + " (" + columnId + ", " + columnName + ", " + columnPhone + ", " + columnEmail + ", " + columnAddress + ") "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setInt(1, empInfo.getEmpId());  // Set the ID
            stmt.setString(2, empInfo.getEmpName());
            stmt.setString(3, empInfo.getEmpPhone());
            stmt.setString(4, empInfo.getEmpEmail());
            stmt.setString(5, empInfo.getEmpAddress());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new EmpDataException("Error occurred while inserting employee data", e);
        }
    }

    @Override
    public boolean updateEmployee(EmpDetails empInfo) throws EmpDataException {
        String tableName = dbProperties.getProperty("db.table.name");
        String columnId = dbProperties.getProperty("db.column.id");
        String columnName = dbProperties.getProperty("db.column.name");
        String columnPhone = dbProperties.getProperty("db.column.phone");
        String columnEmail = dbProperties.getProperty("db.column.email");
        String columnAddress = dbProperties.getProperty("db.column.address");

        String sql = "UPDATE " + tableName + " SET " + columnName + " = ?, " + columnPhone + " = ?, " + columnEmail + " = ?, " + columnAddress + " = ? WHERE " + columnId + " = ?";

        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setString(1, empInfo.getEmpName());
            stmt.setString(2, empInfo.getEmpPhone());
            stmt.setString(3, empInfo.getEmpEmail());
            stmt.setString(4, empInfo.getEmpAddress());
            stmt.setInt(5, empInfo.getEmpId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new EmpDataException("Error occurred while updating employee data", e);
        }
    }

    @Override
    public EmpDetails fetchEmpDetails(int empId) throws EmpDataException, SQLException {
        String tableName = dbProperties.getProperty("db.table.name");
        String columnId = dbProperties.getProperty("db.column.id");
        String columnName = dbProperties.getProperty("db.column.name");
        String columnPhone = dbProperties.getProperty("db.column.phone");
        String columnEmail = dbProperties.getProperty("db.column.email");
        String columnAddress = dbProperties.getProperty("db.column.address");

        String sql = "SELECT " + columnId + ", " + columnName + ", " + columnPhone + ", " + columnEmail + ", " + columnAddress + " FROM " + tableName + " WHERE " + columnId + " = ?";

        EmpDetails empDetails = new EmpDetails();

        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                empDetails.setEmpId(rs.getInt(columnId));
                empDetails.setEmpName(rs.getString(columnName));
                empDetails.setEmpPhone(rs.getString(columnPhone));
                empDetails.setEmpEmail(rs.getString(columnEmail));
                empDetails.setEmpAddress(rs.getString(columnAddress));
            } else {
                throw new EmpDataException("Employee not found with ID: " + empId);
            }
        } catch (SQLException e) {
            throw new EmpDataException("Error occurred while fetching employee data", e);
        }

        return empDetails;
    }

    @Override
    public boolean deleteEmployee(int empId) throws EmpDataException {
        String tableName = dbProperties.getProperty("db.table.name");
        String columnId = dbProperties.getProperty("db.column.id");

        String sql = "DELETE FROM " + tableName + " WHERE " + columnId + " = ?";

        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new EmpDataException("Error occurred while deleting employee data", e);
        }
    }
}
