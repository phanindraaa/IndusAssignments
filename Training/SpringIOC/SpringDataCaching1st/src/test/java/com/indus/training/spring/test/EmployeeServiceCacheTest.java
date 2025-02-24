package com.indus.training.spring.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import com.indus.training.spring.entity.Employee;
import com.indus.training.spring.service.EmployeeService;
import com.indus.training.spring.service.EmployeeServiceImpl;
import com.indus.training.spring.svc.EmployeeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EmployeeServiceCacheTest {

    @Configuration
    @EnableCaching
    static class ContextConfiguration {
        @Bean
        public CacheManager cacheManager() {
            return new ConcurrentMapCacheManager("employeeCache");
        }

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }

        @Bean
        public EmployeeDAO employeeDAO() {
            return mock(EmployeeDAO.class);
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private EmployeeDAO employeeDAO;

    private Employee testEmployee;

    @Before
    public void setUp() {
        testEmployee = new Employee();
        testEmployee.setEmployeeId(1);
        testEmployee.setFirstName("John");
        testEmployee.setLastName("Doe");
        testEmployee.setPosition("Developer");
        testEmployee.setSalary(75000);

        reset(employeeDAO);
        cacheManager.getCache("employeeCache").clear();
    }

    @Test
    public void testGetEmployeeByIdCaching() {
        when(employeeDAO.findById(1)).thenReturn(java.util.Optional.of(testEmployee));

        // First call - should be a cache miss
        Employee result1 = employeeService.getEmployeeById(1);
        assertNotNull(result1);
        assertEquals("John", result1.getFirstName());

        // Second call - should be a cache hit
        Employee result2 = employeeService.getEmployeeById(1);
        assertNotNull(result2);
        assertEquals("John", result2.getFirstName());

        // Verify that the DAO method was called only once (on the first call)
        verify(employeeDAO, times(1)).findById(1);
    }

    @Test
    public void testGetAllEmployeesCaching() {
        List<Employee> employees = Arrays.asList(testEmployee);
        when(employeeDAO.findAll()).thenReturn(employees);

        // First call - should be a cache miss
        List<Employee> result1 = employeeService.getAllEmployees();
        assertFalse(result1.isEmpty());

        // Second call - should be a cache hit
        List<Employee> result2 = employeeService.getAllEmployees();
        assertFalse(result2.isEmpty());

        // Verify that the DAO method was called only once (on the first call)
        verify(employeeDAO, times(1)).findAll();
    }

    // Add more cache-related tests here
}