package com.indus.training.persist.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.indus.training.persist.dao.EmployeeDao;
import com.indus.training.persist.entity.Employees;

public class testEmployee {
	
	private EmployeeDao employeeManager;
	private Employees employee;
	@Before
	public void setUp() throws Exception {
		employeeManager = new EmployeeDao();
		employee = new Employees();
		employee.setName("phani");
		employee.setPhone("12345");
		employee.setEmail("phani@gmail.com");
		employee.setAddress("miamisburg");
		employeeManager.save(employee);
	}

	@After
	public void tearDown() throws Exception {
		if(employeeManager.findById(employee.getId())!=null) {
			employeeManager.delete(employee.getId());
		}
	}

	@Test
	public void testfindbyId() {
		Employees derivedEmployee = employeeManager.findById(employee.getId());
		assertEquals("phani", derivedEmployee.getName());
	}
	
	@Test
	public void testGetAllEmployees() {
		List<Employees> employeesList = employeeManager.getAllEmployees();
		for (Employees name: employeesList) {
			System.out.println(name);
		}
		
		assertNotNull(employeesList);
	}
	
	@Test
	public void testUpdateEmployee() {
		employee.setEmail("sai@gmail.com");
		employeeManager.update(employee);
		
		assertEquals(employee.getEmail(), "sai@gmail.com");
	}
	
	@Test
	public void testDeleteEmployee() {
		employeeManager.delete(employee.getId());
		
		Employees derivedEmp = employeeManager.findById(employee.getId());
		assertNull(derivedEmp);
	}
}
