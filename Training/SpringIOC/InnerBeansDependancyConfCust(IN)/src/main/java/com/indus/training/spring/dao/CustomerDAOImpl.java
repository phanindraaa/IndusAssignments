package com.indus.training.spring.dao;

import com.indus.training.spring.entity.Customers;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Customers> findAll() {
        return entityManager.createQuery("FROM Customers", Customers.class).getResultList();
    }

    public Customers save(Customers customer) {
        if (customer.getCustomerId() == 0) {
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer);
        }
        return customer;
    }

    // Implement other methods as needed
}