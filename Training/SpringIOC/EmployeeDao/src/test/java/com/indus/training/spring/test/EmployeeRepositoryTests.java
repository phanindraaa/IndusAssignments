package com.indus.training.spring.test;

import com.indus.training.spring.config.JpaConfig;
import com.indus.training.spring.entity.Employee;
import com.indus.training.spring.dao.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

public class EmployeeRepositoryTests {

    private EmployeeRepository employeeRepository;
    private ApplicationContext context;

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(JpaConfig.class);
        employeeRepository = context.getBean(EmployeeRepository.class);
    }

    @After
    public void cleanup() {
        // Clean up the database after each test
        employeeRepository.deleteAll();
        
        // Close the application context
        if (context != null && context instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) context).close();
        }
    }

    @Test
    public void testSaveEmployee() {
        BigDecimal salary = new BigDecimal("50000.00");
        Employee employee = new Employee("John", "Doe", "john.doe@example.com", salary);
        
        Employee savedEmployee = employeeRepository.save(employee);

        assertTrue(savedEmployee.getId() > 0);
        assertEquals("John", savedEmployee.getFirstName());
    }

    @Test
    public void testFindEmployeeById() {
        BigDecimal salary = new BigDecimal("50000.00");
        Employee employee = new Employee("Jane", "Doe", "jane.doe@example.com", salary);
        Employee savedEmployee = employeeRepository.save(employee);

        Optional<Employee> retrievedEmployee = employeeRepository.findById(savedEmployee.getId());
        assertTrue(retrievedEmployee.isPresent());
        assertEquals("jane.doe@example.com", retrievedEmployee.get().getEmail());
    }

    @Test
    public void testDeleteEmployee() {
        BigDecimal salary = new BigDecimal("50000.00");
        Employee employee = new Employee("Mark", "Smith", "mark.smith@example.com", salary);
        Employee savedEmployee = employeeRepository.save(employee);

        employeeRepository.deleteById(savedEmployee.getId());
        Optional<Employee> deletedEmployee = employeeRepository.findById(savedEmployee.getId());
        assertTrue(deletedEmployee.isEmpty());
    }
}