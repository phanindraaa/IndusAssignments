package com.indus.training.spring.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indus.training.spring.entity.Employee;
import com.indus.training.spring.service.EmployeeService;
import com.indus.training.spring.service.EmployeeServiceImpl;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private ApplicationContext context;
    private int emp1Id;
    private int emp2Id;

    @Before
    public void setUp() {
        // Initialize the Spring ApplicationContext before each test
        context = new ClassPathXmlApplicationContext("classpath:services.xml", "classpath:daos.xml");

        employeeService = context.getBean("employeeService", EmployeeService.class);
        // Setting up initial data for testing and capturing dynamic IDs
        Employee emp1 = new Employee();
        emp1.setFirstName(generateRandomString());
        emp1.setLastName(generateRandomString());
        emp1.setPosition("Developer");
        emp1.setSalary(75000);
        emp1Id = employeeService.saveEmployee(emp1); // Capture the ID of the saved employee dynamically

        Employee emp2 = new Employee();
        emp2.setFirstName(generateRandomString());
        emp2.setLastName(generateRandomString());
        emp2.setPosition("Manager");
        emp2.setSalary(85000);
        emp2Id = employeeService.saveEmployee(emp2); // Capture the second employee ID dynamically
    }

    @After
    public void tearDown() {
        // Clean up after each test
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testAddEmployeeAndRetrieve() {
        // Adding a new employee with dynamic values
        Employee emp = new Employee();
        emp.setFirstName(generateRandomString());
        emp.setLastName(generateRandomString());
        emp.setPosition("Analyst");
        emp.setSalary(65000);

        // Saving the employee and asserting it is added
        int newEmpId = employeeService.saveEmployee(emp);

        // Retrieving all employees
        List<Employee> employeeList = employeeService.getAllEmployees();

        // Asserting the size of employee list is increased
//        assertEquals(expectedSize, employeeList.size());

        // Asserting the newly added employee details
        Employee retrievedEmployee = employeeService.getEmployeeById(newEmpId); // Dynamically fetch by ID instead of index
        assertEquals(emp.getFirstName(), retrievedEmployee.getFirstName());
        assertEquals(emp.getLastName(), retrievedEmployee.getLastName());
        assertEquals(emp.getPosition(), retrievedEmployee.getPosition());
        assertEquals(emp.getSalary(), retrievedEmployee.getSalary(), 0.1);
    }


    @Test
    public void testGetEmployeeById() {
        // Fetching employee by dynamically captured emp1Id and verifying details
        Employee employee = employeeService.getEmployeeById(emp1Id);
        assertEquals("Developer", employee.getPosition());
        assertEquals(75000, employee.getSalary(), 0.1);
    }

    @Test
    public void testDeleteEmployee() {
        // Deleting the dynamically captured emp1Id
        employeeService.deleteEmployee(emp1Id);

        // Retrieving remaining employees
        List<Employee> employeeList = employeeService.getAllEmployees();
//        assertEquals(1, employeeList.size());

        // Verifying the remaining employee details
        Employee remainingEmployee = employeeList.get(0);
        assertEquals("Manager", remainingEmployee.getPosition());
    }

    // Utility method to generate random names for dynamic testing
    private String generateRandomString() {
        return java.util.UUID.randomUUID().toString().substring(0, 5);  // Random 5-character string
    }
}
