package com.indus.training.persist.svc;

import com.indus.training.persist.entity.Employees;

import java.util.List;

public interface IEmployee {
    void save(Employees employee);
    Employees findById(long id);
    List<Employees> getAllEmployees();
    void update(Employees employee);
    void delete(long id);
}
