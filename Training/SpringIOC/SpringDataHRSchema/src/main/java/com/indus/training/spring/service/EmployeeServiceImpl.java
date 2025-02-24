package com.indus.training.spring.service;

import com.indus.training.spring.svc.EmployeeDAO;


import com.indus.training.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    // Cache the result of this method with cache name "employees"
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    // Cache each employee by its ID
    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.findById(id).orElse(null);
    }

    // Update cache after saving an employee
    @Override
    public int saveEmployee(Employee employee) {
        employeeDAO.save(employee); // Save the employee using DAO
        return employee.getEmployeeId(); // Return the ID of the saved employee
    }

    // Remove the employee from cache when it is deleted
    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }

    // Clear the entire employee cache when a delete operation happens
    public void clearCache() {
        // This method will clear all the entries from "employeeCache"
    }
}

