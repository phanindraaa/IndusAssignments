package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    private EmployeeDAO employeeDAO;

    @Before
    public void setUp() {
        try {
			Class employeeDaoClassObj = Class.forName("com.indus.training.persist.dao.EmployeeDAO");
			Object tempEmployeeDAO = employeeDaoClassObj.newInstance();
			employeeDAO = (EmployeeDAO) tempEmployeeDAO;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    @Test
    public void testSaveEmployee() {
        Set<Address> addresses = new HashSet<>();
        Object employeeCons = null;
     
        try {
			Class addressClassObj = Class.forName("com.indus.training.persist.entity.Address");
			Constructor adressConstructor = addressClassObj.getConstructor(String.class, String.class, String.class);
			addresses.add((Address) adressConstructor.newInstance("123 Main St", "New York", "USA"));
			addresses.add((Address) adressConstructor.newInstance("456 Broadway", "Los Angeles", "USA"));
			
			Class employeeClassObj = Class.forName("com.indus.training.persist.entity.Employee");	
			employeeCons = employeeClassObj.getDeclaredConstructor().newInstance();
			Method setFname = employeeClassObj.getMethod("setFirstName", String.class);
			Method setLastName = employeeClassObj.getMethod("setLastName", String.class);
			Field addresSet = employeeClassObj.getDeclaredField("addresses");
			addresSet.setAccessible(true);
			addresSet.set(employeeCons, addresses);
			
			setFname.invoke(employeeCons, "John");
			setLastName.invoke(employeeCons, "Doe");
//			employee.setFirstName("John");
//	        employee.setLastName("Doe");
//	        employee.setAddresses(addresses);
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        addresses.add((Address) addrObj);
//        addresses.add((Address) addrObj2);
        catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        

        employeeDAO.saveEmployee((Employee) employeeCons);

        assertNotNull(((Employee) employeeCons).getEmployeeID());  // Ensure employee is saved and ID is generated
    }

//    @Test
//    public void testGetEmployeeById() {
//        // Step 1: Save a new employee
//        Employee employee = new Employee();
//        employee.setFirstName("TestFirstName");
//        employee.setLastName("TestLastName");
//
//        employeeDAO.saveEmployee(employee);
//        Long employeeID = employee.getEmployeeID();
//
//        // Step 2: Retrieve the saved employee using its ID
//        Employee retrievedEmployee = employeeDAO.getEmployeeById(employeeID);
//
//        // Step 3: Assert the employee was correctly retrieved
//        assertNotNull(retrievedEmployee);  // Ensure employee was retrieved
//        assertEquals("TestFirstName", retrievedEmployee.getFirstName());
//        assertEquals("TestLastName", retrievedEmployee.getLastName());
//    }
//
//    @Test
//    public void testGetAllEmployees() {
//        assertNotNull(employeeDAO.getAllEmployees());
//    }
//
//    @Test
//    public void testDeleteEmployee() {
//        Employee employee = new Employee();
//        employee.setFirstName("Jane");
//        employee.setLastName("Doe");
//
//        employeeDAO.saveEmployee(employee);
//        Long employeeID = employee.getEmployeeID();
//        assertNotNull(employeeID);
//
//        employeeDAO.deleteEmployee(employeeID);
//
//        assertNull(employeeDAO.getEmployeeById(employeeID));
//    }
//
//    @Test
//    public void testUpdateEmployee() {
//        // Step 1: Save a new employee
//        Employee employee = new Employee();
//        employee.setFirstName("InitialFirstName");
//        employee.setLastName("InitialLastName");
//
//        employeeDAO.saveEmployee(employee);
//        Long employeeID = employee.getEmployeeID();
//
//        // Step 2: Update the employee's last name
//        employee.setLastName("UpdatedLastName");
//        employeeDAO.updateEmployee(employee);
//
//        // Step 3: Retrieve the updated employee and check if the last name was updated
//        Employee updatedEmployee = employeeDAO.getEmployeeById(employeeID);
//        assertNotNull(updatedEmployee);  // Ensure employee was retrieved
//        assertEquals("UpdatedLastName", updatedEmployee.getLastName());  // Ensure last name was updated
//    }

    @After
    public void tearDown() {
        employeeDAO = null;
    }
}
