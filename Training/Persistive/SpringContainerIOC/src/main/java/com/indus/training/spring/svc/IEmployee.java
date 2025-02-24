package com.indus.training.spring.svc;

import com.indus.training.persist.entity.Employees;
import java.util.List;

public interface IEmployee {
    Employees save(Employees employee);
    Employees findById(long id);
    List<Employees> findAll();
    void delete(long id);
}
