package com.indus.training.spring.service;

import com.indus.training.spring.svc.EmployeeDAO;
import com.indus.training.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Cacheable(value = "employeeCache", key = "'allEmployees'")
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    @Cacheable(value = "employeeCache", key = "#root.args[0]")
    public Employee getEmployeeById(int id) {
        return employeeDAO.findById(id).orElse(null);
    }
    


    @Override
    @CachePut(value = "employeeCache", key = "#result", condition = "#result != null")
    @CacheEvict(value = "employeeCache", key = "'allEmployees'")
    public int saveEmployee(Employee employee) {
        Employee savedEmployee = employeeDAO.save(employee);
        return savedEmployee != null ? savedEmployee.getEmployeeId() : -1;
    }

    @Override
    @CacheEvict(value = "employeeCache", allEntries = true)
    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }
}