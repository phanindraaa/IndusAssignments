package com.indus.training.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import com.indus.training.persist.entity.Employees;
import com.indus.training.persist.impl.EmployeeManager;

public class EmployeeHibernateUi {
	 public static void main(String[] args) throws SQLException {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        Employees empDetailsObj = new Employees();

	        EmployeeManager employeeObj = new EmployeeManager();
	        int choice;

	        while (true) {
//	            System.out.println("****************************");
	            System.out.println(" Employee Management Menu ");
	            System.out.println(" 1. Insert Employee       ");
	            System.out.println(" 2. Update Employee       ");
	            System.out.println(" 3. Delete Employee       ");
	            System.out.println(" 4. Fetch Employee        ");
	            System.out.println(" 5. Quit                  ");
	            System.out.println(" Enter your choice:       ");
//	            System.out.println("****************************");

	            try {
	                choice = Integer.parseInt(reader.readLine());

	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter Employee ID: ");
	                        Integer id = Integer.parseInt(reader.readLine());
	                        empDetailsObj.setId(choice);

	                        System.out.print("Enter Employee Name: ");
	                        String name = reader.readLine();
	                        empDetailsObj.setName(name);
	                        
	                        System.out.print("Enter Employee Phone: ");
	                        String phone = reader.readLine();
	                        empDetailsObj.setPhone(phone);
	                        
	                        System.out.print("Enter Employee Email: ");
	                        String email = reader.readLine();
	                        empDetailsObj.setEmail(email);

	                        System.out.print("Enter Employee Addr: ");
	                        String Address = reader.readLine();
	                        empDetailsObj.setAddress(Address);
	                        
	                        employeeObj.insert(id, name, phone, email, Address);
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
	                        break;

	                    case 2:
	                        System.out.print("Enter Employee ID to update: ");
	                        id = Integer.parseInt(reader.readLine());
	                        empDetailsObj.setId(id);

	                        // Fetch existing details
	                        Employees existingDetails = employeeObj.fetch(id);
	                        if (existingDetails == null) {
	                            System.out.println("Employee with ID " + id + " does not exist.");
	                            break;
	                        }

	                        System.out.print("Enter new Employee Name (current: " + existingDetails.getName() + "): ");
	                        name = reader.readLine();
	                        empDetailsObj.setName(name);

	                        System.out.print("Enter new Employee Phone (current: " + existingDetails.getPhone() + "): ");
	                        phone = reader.readLine();
	                        empDetailsObj.setPhone(phone);

	                        System.out.print("Enter new Employee Email (current: " + existingDetails.getEmail() + "): ");
	                        email = reader.readLine();
	                        empDetailsObj.setEmail(email);
	                        
	                        System.out.print("Enter new Employee Addr (current: " + existingDetails.getAddress() + "): ");
	                        Address = reader.readLine();
	                        empDetailsObj.setAddress(Address);

	                        employeeObj.update(id, name, phone, email, Address);
	                        System.out.println("Employee updated successfully.");
	                        break;

	                    case 3:
	                        System.out.print("Enter Employee ID to delete: ");
	                        id = Integer.parseInt(reader.readLine());

	                        employeeObj.delete(id);
						System.out.println("Employee deleted successfully.");
	                        break;

	                    case 4:
	                        System.out.print("Enter Employee ID to fetch: ");
	                        id = Integer.parseInt(reader.readLine());

	                        Employees fetchedDetails = employeeObj.fetch(id);
	                        if (fetchedDetails != null) {
	                            String[] headers1 = {"ID", "Name", "Phone", "Email", "Address"};
	                            String[] data1 = {
	                                String.valueOf(fetchedDetails.getId()),
	                                fetchedDetails.getName(),
	                                fetchedDetails.getPhone(),
	                                fetchedDetails.getEmail(),
	                                fetchedDetails.getAddress()
	                            };

	                            int[] maxWidths1 = new int[headers1.length];
	                            for (int i = 0; i < headers1.length; i++) {
	                                maxWidths1[i] = Math.max(headers1[i].length(), data1[i].length());
	                            }

	                            StringBuilder lineBuilder1 = new StringBuilder();
	                            for (int width : maxWidths1) {
	                                lineBuilder1.append("+").append("-".repeat(width + 2));
	                            }
	                            lineBuilder1.append("+");

	                            String line1 = lineBuilder1.toString();

	                            // Print header line
	                            System.out.println(line1);
	                            System.out.print("|");
	                            for (int i = 0; i < headers1.length; i++) {
	                                System.out.printf(" %-" + maxWidths1[i] + "s |", headers1[i]);
	                            }
	                            System.out.println();
	                            System.out.println(line1);

	                            // Print data line
	                            System.out.print("|");
	                            for (int i = 0; i < data1.length; i++) {
	                                System.out.printf(" %-" + maxWidths1[i] + "s |", data1[i]);
	                            }
	                            System.out.println();
	                            System.out.println(line1);
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
