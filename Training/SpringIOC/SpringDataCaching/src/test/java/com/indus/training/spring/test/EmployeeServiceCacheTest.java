package com.indus.training.spring.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
        reset(employeeDAO);
    }

    @Test
    public void testGetEmployeeByIdCaching() {
        when(employeeDAO.findById(1)).thenReturn(Optional.of(testEmployee));

        // First call should hit the database
        Employee result1 = employeeService.getEmployeeById(1);
        assertNotNull(result1);
        assertEquals("John", result1.getFirstName());

        // Second call should hit the cache
        Employee result2 = employeeService.getEmployeeById(1);
        assertNotNull(result2);
        assertEquals("John", result2.getFirstName());

        // Verify that the DAO method was called only once
        verify(employeeDAO, times(1)).findById(1);
    }

    @Test
    public void testGetAllEmployeesCaching() {
        List<Employee> employees = Arrays.asList(testEmployee);
        when(employeeDAO.findAll()).thenReturn(employees);

        // First call should hit the database
        List<Employee> result1 = employeeService.getAllEmployees();
        assertFalse(result1.isEmpty());

        // Second call should hit the cache
        List<Employee> result2 = employeeService.getAllEmployees();
        assertFalse(result2.isEmpty());

        // Verify that the DAO method was called only once
        verify(employeeDAO, times(1)).findAll();
    }

    @Test
    public void testSaveEmployeeCacheEviction() {
        employeeService.saveEmployee(testEmployee);

        // Verify that the cache for 'allEmployees' is evicted
        assertNull(cacheManager.getCache("employeeCache").get("allEmployees"));
    }

    @Test
    public void testDeleteEmployeeCacheEviction() {
        employeeService.deleteEmployee(1);

        // Verify that all entries in the cache are evicted
//        assertNull(cacheManager.getCache("employeeCache").get("allEmployees"));
        assertNull(cacheManager.getCache("employeeCache").get(1));
    }
}