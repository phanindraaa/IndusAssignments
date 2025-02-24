package com.indus.training.persist.dac.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.indus.training.persist.dac.IEmpData;
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

	        File file = new File(directory, "Employee_" + empInfo.getEmpId() + ".txt");

	        if (file.exists()) {
	            throw new EmpDataException("File already exists for Employee ID: " + empInfo.getEmpId());
	        }

	        if (!file.createNewFile()) {
	            throw new EmpDataException("Failed to create file: " + file.getAbsolutePath());
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            writer.write("Employee ID: " + empInfo.getEmpId());
	            writer.newLine();
	            writer.write("Employee Name: " + empInfo.getEmpName());
	            writer.newLine();
	            writer.write("Employee Phone: " + empInfo.getEmpPhone());
	            writer.newLine();
	            writer.write("Employee Email: " + empInfo.getEmpEmail());
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
            File file = new File(currentDir + "/EmployeeFiles/Employee_" + empInfo.getEmpId() + ".txt");

            if (!file.exists()) {
                throw new EmpDataException("Employee file not found for ID: " + empInfo.getEmpId());
            } else {
                if (!file.delete()) {
                    throw new EmpDataException("Failed to delete old employee file for ID: " + empInfo.getEmpId());
                }
            }

            File newFile = new File(currentDir + "/EmployeeFiles/Employee_" + empInfo.getEmpId() + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile, false))) {
                writer.write("Employee ID: " + empInfo.getEmpId());
                writer.newLine();
                writer.write("Employee Name: " + empInfo.getEmpName());
                writer.newLine();
                writer.write("Employee Phone: " + empInfo.getEmpPhone());
                writer.newLine();
                writer.write("Employee Email: " + empInfo.getEmpEmail());
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
        File file = new File(currentDir + "/EmployeeFiles/Employee_" + empId + ".txt");

        if (!file.exists()) {
            throw new EmpDataException("Employee file not found for ID: " + empId);
        }

        EmpDetails empDetails = new EmpDetails();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            empDetails.setEmpId(Integer.parseInt(reader.readLine().split(": ")[1]));
            empDetails.setEmpName(reader.readLine().split(": ")[1]);
            empDetails.setEmpPhone(reader.readLine().split(": ")[1]);
            empDetails.setEmpEmail(reader.readLine().split(": ")[1]);
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
            File file = new File(currentDir + "/EmployeeFiles/Employee_" + empId + ".txt");

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
