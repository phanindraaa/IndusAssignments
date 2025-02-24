package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeManagerJpa {

    private EntityManagerFactory entityManagerFactory;

    public EmployeeManagerJpa() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public void save(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Employee findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
    }

    public List<Employee> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employees = query.getResultList();
        entityManager.close();
        return employees;
    }

    public void update(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
