package com.indus.training.spring.service;

import com.indus.training.spring.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    int saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
