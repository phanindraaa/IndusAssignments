package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employees;
import com.indus.training.persist.svc.IEmployee;
import com.indus.training.persist.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDao implements IEmployee {
    
    private EntityManagerFactory entityManagerFactory;

    // Constructor to initialize EntityManagerFactory
    public EmployeeDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistJpa");
    }

    @Override
    public void save(Employees employee) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Employees findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employees employee = entityManager.find(Employees.class, id);
        entityManager.close();
        return employee;
    }

    @Override
    public List<Employees> getAllEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employees> query = entityManager.createQuery("SELECT e from Employees e", Employees.class);
        List<Employees> employees = query.getResultList();
        entityManager.close();
        return employees;
    }

    @Override
    public void update(Employees employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Employees employee = entityManager.find(Employees.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
