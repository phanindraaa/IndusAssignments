package com.indus.training.spring.service;

import com.indus.training.spring.svc.EmployeeDAO;
import com.indus.training.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	    private EmployeeDAO employeeDAO;

	@Override
    @Cacheable(value = "employeeCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    public Employee getEmployeeById(int id) {
        System.out.println("Fetching employee with ID: " + id + " from database");
        return employeeDAO.findById(id).orElse(null);
    }

    @Override
    @CachePut(value = "employeeCache", key = "#employee.employeeId", unless = "#result == null")
    public int saveEmployee(Employee employee) {
        Employee savedEmployee = employeeDAO.save(employee);
        return savedEmployee.getEmployeeId();
    }
    @Override
    @Cacheable(value = "employeeCache", unless = "#result.isEmpty()")
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }
    
    @Override
    @CacheEvict(value = "employeeCache", key = "#root.args[0]")
    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }

    @CacheEvict(value = "employeeCache", allEntries = true)
    public void clearAllCache() {
        // This method can be called to clear the entire cache
    }
}