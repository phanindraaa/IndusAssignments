package com.indus.training.persist.test;

import com.indus.training.persist.entity.Employees;
import com.indus.training.spring.svc.IEmployee;
import com.indus.training.persist.dao.EmployeeDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class testEmployee {

    private EntityManagerFactory emf;
    private EntityManager entityManager;
    private IEmployee employeesRepository;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("employees-pu");
        entityManager = emf.createEntityManager();
        employeesRepository = new EmployeeDao(entityManager); // Pass the EntityManager here

        // Initialize test data
        entityManager.getTransaction().begin();
        Employees employee = new Employees();
        employee.setName("John Doe");
        employee.setPhone("1234567890");
        employee.setEmail("johndoe@example.com");
        employee.setAddress("123 Main St");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    @After
    public void tearDown() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Employees").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }

    @Test
    public void testFindById() {
        Employees employee = employeesRepository.findById(1L); // Assuming the inserted employee has ID 1
        assertNotNull(employee);
        assertEquals("John Doe", employee.getName());
    }

    @Test
    public void testSaveEmployee() {
        Employees employee = new Employees();
        employee.setName("Jane Smith");
        employee.setPhone("0987654321");
        employee.setEmail("janesmith@example.com");
        employee.setAddress("456 Elm St");

        entityManager.getTransaction().begin();
        employeesRepository.save(employee);
        entityManager.getTransaction().commit();

        assertNotNull(employee.getId()); // Assuming the ID gets generated after save
        assertEquals("Jane Smith", employeesRepository.findById(employee.getId()).getName());
    }
}
