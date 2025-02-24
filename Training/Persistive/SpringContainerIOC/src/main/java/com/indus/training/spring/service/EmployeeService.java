package com.indus.training.spring.service;

import com.indus.training.persist.entity.Employees;
import com.indus.training.spring.svc.IEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private IEmployee employeesRepository;

    public Employees saveEmployee(Employees employee) {
        return employeesRepository.save(employee);
    }

    public Employees getEmployeeById(long id) {
        return employeesRepository.findById(id);
    }

    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    public void deleteEmployee(long id) {
        employeesRepository.delete(id);
    }
}
