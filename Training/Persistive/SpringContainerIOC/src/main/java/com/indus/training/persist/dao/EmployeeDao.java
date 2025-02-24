package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employees;
import com.indus.training.spring.svc.IEmployee;

import jakarta.transaction.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDao implements IEmployee {

    private EntityManager entityManager;

    // Constructor accepting EntityManager
    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Employees save(Employees employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Employees findById(long id) {
        return entityManager.find(Employees.class, id);
    }

    @Override
    public List<Employees> findAll() {
        return entityManager.createQuery("FROM Employees", Employees.class).getResultList();
    }

    @Override
    @Transactional
    public void delete(long id) {
        Employees employee = findById(id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}
