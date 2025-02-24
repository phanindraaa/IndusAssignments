package com.indus.training.persist.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.indus.training.persist.dao.IEmpData;
import com.indus.training.persist.entity.EmpDetails;
import com.indus.training.persist.exception.EmpDataException;

public class EmpData implements IEmpData {

    @Override
    public boolean insertEmployee(EmpDetails empInfo) throws EmpDataException {
        try {
            // Get the current working directory
            String currentDir = System.getProperty("user.dir");
            File directory = new File(currentDir, "EmployeeFiles");

            if (!directory.exists()) {
                if (!directory.mkdirs()) {
                    throw new EmpDataException("Failed to create directory: " + directory.getAbsolutePath());
                }
            }

            File file = new File(directory, "Employee_" + empInfo.getEmpId() + ".csv");

            if (file.exists()) {
                throw new EmpDataException("File already exists for Employee ID: " + empInfo.getEmpId());
            }

            if (!file.createNewFile()) {
                throw new EmpDataException("Failed to create file: " + file.getAbsolutePath());
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            	writer.write( "EmpId,EmpName,EmpPhone,EmpEmail");
            	writer.newLine();
                writer.write(empInfo.getEmpId() + "," + empInfo.getEmpName() + "," + empInfo.getEmpPhone() + "," + empInfo.getEmpEmail());
            }

            return true;
        } catch (IOException e) {
            throw new EmpDataException("Error occurred while inserting employee data", e);
        }
    }

    @Override
    public boolean updateEmployee(EmpDetails empInfo) throws EmpDataException {
        try {
            // Get the current working directory
            String currentDir = System.getProperty("user.dir");
            File file = new File(currentDir + "/EmployeeFiles/Employee_" + empInfo.getEmpId() + ".csv");

            if (!file.exists()) {
                throw new EmpDataException("Employee file not found for ID: " + empInfo.getEmpId());
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            	writer.write( "EmpId,EmpName,EmpPhone,EmpEmail");
            	writer.newLine();
                writer.write(empInfo.getEmpId() + "," + empInfo.getEmpName() + "," + empInfo.getEmpPhone() + "," + empInfo.getEmpEmail());
            }

            return true;
        } catch (IOException e) {
            throw new EmpDataException("Error occurred while updating employee data", e);
        }
    }

    @Override
    public EmpDetails fetchEmpDetails(int empId) throws EmpDataException, IOException {
        // Get the current working directory
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir + "/EmployeeFiles/Employee_" + empId + ".csv");

        if (!file.exists()) {
            throw new EmpDataException("Employee file not found for ID: " + empId);
        }

        EmpDetails empDetails = new EmpDetails();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] data = reader.readLine().split(",");
            empDetails.setEmpId(Integer.parseInt(data[0]));
            empDetails.setEmpName(data[1]);
            empDetails.setEmpPhone(data[2]);
            empDetails.setEmpEmail(data[3]);
        } catch (IOException e) {
            throw new EmpDataException("Error occurred while fetching employee details", e);
        }

        return empDetails;
    }

    @Override
    public boolean deleteEmployee(int empId) throws EmpDataException {
        try {
            // Get the current working directory
            String currentDir = System.getProperty("user.dir");
            File file = new File(currentDir + "/EmployeeFiles/Employee_" + empId + ".csv");

            if (!file.exists()) {
                throw new EmpDataException("Employee file not found for ID: " + empId);
            }

            if (!file.delete()) {
                throw new EmpDataException("Failed to delete employee file for ID: " + empId);
            }

            return true;
        } catch (SecurityException e) {
            throw new EmpDataException("Permission denied while deleting employee file", e);
        }
    }
}
