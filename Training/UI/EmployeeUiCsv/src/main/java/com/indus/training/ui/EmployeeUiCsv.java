package com.indus.training.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import com.indus.training.persist.entity.EmpDetails;
import com.indus.training.persist.exception.EmpDataException;
import com.indus.training.persist.dao.impl.EmpData;

public class EmployeeUiCsv {
    public static void main(String[] args) throws EmpDataException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EmpDetails empDetailsObj = new EmpDetails();
        EmpData employeeObj = new EmpData();
        int choice;

        while (true) {
//            System.out.println("****************************");
            System.out.println(" Employee Management Menu ");
            System.out.println(" 1. Insert Employee       ");
            System.out.println(" 2. Update Employee       ");
            System.out.println(" 3. Delete Employee       ");
            System.out.println(" 4. Fetch Employee        ");
            System.out.println(" 5. Quit                  ");
            System.out.println(" Enter your choice:       ");
//            System.out.println("****************************");

            try {
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        Integer id = Integer.parseInt(reader.readLine());
                        empDetailsObj.setEmpId(id);

                        System.out.print("Enter Employee Name: ");
                        String name = reader.readLine();
                        empDetailsObj.setEmpName(name);
                        
                        System.out.print("Enter Employee Phone: ");
                        String phone = reader.readLine();
                        empDetailsObj.setEmpPhone(phone);
                        
                        System.out.print("Enter Employee Email: ");
                        String email = reader.readLine();
                        empDetailsObj.setEmpEmail(email);

                        boolean insertStatus = employeeObj.insertEmployee(empDetailsObj);
                        if (insertStatus) {
                            System.out.println("Employee inserted successfully.");
                            String[] headers = {"ID", "Name", "Phone", "Email"};
                            String[] data = {
                                String.valueOf(id),
                                name,
                                phone,
                                email
                            };

                            int[] maxWidths = new int[headers.length];
                            for (int i = 0; i < headers.length; i++) {
                                maxWidths[i] = Math.max(headers[i].length(), data[i].length());
                            }

                            StringBuilder lineBuilder = new StringBuilder();
                            for (int width : maxWidths) {
                                lineBuilder.append("+").append("-".repeat(width + 2));
                            }
                            lineBuilder.append("+");

                            String line = lineBuilder.toString();

                            // Print header line
                            System.out.println(line);
                            System.out.print("|");
                            for (int i = 0; i < headers.length; i++) {
                                System.out.printf(" %-" + maxWidths[i] + "s |", headers[i]);
                            }
                            System.out.println();
                            System.out.println(line);

                            // Print data line
                            System.out.print("|");
                            for (int i = 0; i < data.length; i++) {
                                System.out.printf(" %-" + maxWidths[i] + "s |", data[i]);
                            }
                            System.out.println();
                            System.out.println(line);
                        } else {
                            System.out.println("Failed to insert employee.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter Employee ID to update: ");
                        id = Integer.parseInt(reader.readLine());
                        empDetailsObj.setEmpId(id);

                        // Fetch existing details
                        EmpDetails existingDetails = employeeObj.fetchEmpDetails(id);
                        if (existingDetails == null) {
                            System.out.println("Employee with ID " + id + " does not exist.");
                            break;
                        }

                        System.out.print("Enter new Employee Name (current: " + existingDetails.getEmpName() + "): ");
                        name = reader.readLine();
                        empDetailsObj.setEmpName(name.isEmpty() ? existingDetails.getEmpName() : name);

                        System.out.print("Enter new Employee Phone (current: " + existingDetails.getEmpPhone() + "): ");
                        phone = reader.readLine();
                        empDetailsObj.setEmpPhone(Integer.parseInt(phone) == 0 ? existingDetails.getEmpPhone() : phone);

                        System.out.print("Enter new Employee Email (current: " + existingDetails.getEmpEmail() + "): ");
                        email = reader.readLine();
                        empDetailsObj.setEmpEmail(email.isEmpty() ? existingDetails.getEmpEmail() : email);

                        boolean updateStatus = employeeObj.updateEmployee(empDetailsObj);
                        if (updateStatus) {
                            System.out.println("Employee updated successfully.");
                        
                        } else {
                            System.out.println("Failed to update employee.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to delete: ");
                        id = Integer.parseInt(reader.readLine());

                        boolean deleteStatus = employeeObj.deleteEmployee(id);
                        if (deleteStatus) {
                            System.out.println("Employee deleted successfully.");
                        } else {
                            System.out.println("Failed to delete employee.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to fetch: ");
                        id = Integer.parseInt(reader.readLine());

                        EmpDetails fetchedDetails = employeeObj.fetchEmpDetails(id);
                        if (fetchedDetails != null) {
                            String[] headers = {"ID", "Name", "Phone", "Email"};
                            String[] data = {
                                String.valueOf(fetchedDetails.getEmpId()),
                                fetchedDetails.getEmpName(),
                                fetchedDetails.getEmpPhone(),
                                fetchedDetails.getEmpEmail()
                            };

                            int[] maxWidths = new int[headers.length];
                            for (int i = 0; i < headers.length; i++) {
                                maxWidths[i] = Math.max(headers[i].length(), data[i].length());
                            }

                            StringBuilder lineBuilder = new StringBuilder();
                            for (int width : maxWidths) {
                                lineBuilder.append("+").append("-".repeat(width + 2));
                            }
                            lineBuilder.append("+");

                            String line = lineBuilder.toString();

                            // Print header line
                            System.out.println(line);
                            System.out.print("|");
                            for (int i = 0; i < headers.length; i++) {
                                System.out.printf(" %-" + maxWidths[i] + "s |", headers[i]);
                            }
                            System.out.println();
                            System.out.println(line);

                            // Print data line
                            System.out.print("|");
                            for (int i = 0; i < data.length; i++) {
                                System.out.printf(" %-" + maxWidths[i] + "s |", data[i]);
                            }
                            System.out.println();
                            System.out.println(line);
                        } else {
                            System.out.println("Employee with ID " + id + " does not exist.");
                        }
                        break;


                    case 5:
                        System.out.println("Exiting the program.");
                        return;

                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
