package com.indus.training.spring.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.indus.training.spring.config.AppConfig;
import com.indus.training.spring.entity.Employee;
import com.indus.training.spring.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestHitMiss {

    @Autowired
    private EmployeeService employeeService;

    private int emp1Id;
    private int emp2Id;

    @Before
    public void setUp() {
        // Setting up initial data for testing and capturing dynamic IDs
        Employee emp1 = new Employee();
        emp1.setFirstName(generateRandomString());
        emp1.setLastName(generateRandomString());
        emp1.setPosition("Developer");
        emp1.setSalary(75000);
        emp1Id = employeeService.saveEmployee(emp1);

        Employee emp2 = new Employee();
        emp2.setFirstName(generateRandomString());
        emp2.setLastName(generateRandomString());
        emp2.setPosition("Manager");
        emp2.setSalary(85000);
        emp2Id = employeeService.saveEmployee(emp2);
    }

    @After
    public void tearDown() {
        // Clean up after each test if needed
    }

    @Test
    public void testAddEmployeeAndRetrieve() {
        Employee emp = new Employee();
        emp.setFirstName(generateRandomString());
        emp.setLastName(generateRandomString());
        emp.setPosition("Analyst");
        emp.setSalary(65000);

        int newEmpId = employeeService.saveEmployee(emp);

        List<Employee> employeeList = employeeService.getAllEmployees();

        Employee retrievedEmployee = employeeService.getEmployeeById(newEmpId);
        assertEquals(emp.getFirstName(), retrievedEmployee.getFirstName());
        assertEquals(emp.getLastName(), retrievedEmployee.getLastName());
        assertEquals(emp.getPosition(), retrievedEmployee.getPosition());
        assertEquals(emp.getSalary(), retrievedEmployee.getSalary(), 0.1);
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = employeeService.getEmployeeById(emp1Id);
        assertEquals("Developer", employee.getPosition());
        assertEquals(75000, employee.getSalary(), 0.1);
    }

    @Test
    public void testDeleteEmployee() {
        employeeService.deleteEmployee(emp1Id);

        List<Employee> employeeList = employeeService.getAllEmployees();

        Employee remainingEmployee = employeeList.stream()
            .filter(e -> e.getEmployeeId() == emp2Id)
            .findFirst()
            .orElse(null);

        assertEquals("Manager", remainingEmployee.getPosition());
    }

    private String generateRandomString() {
        return java.util.UUID.randomUUID().toString().substring(0, 5);
    }
}