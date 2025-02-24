package com.indus.training.persist.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.indus.training.persist.entity.Employees;
import com.indus.training.persist.util.JpaUtil;

public class EmployeeManagerJpa {

	 public void insert(int id, String name, String phone, String email, String address) {
	        EntityManager entityManager = null;
	        EntityTransaction transaction = null;
	        try {
	            entityManager = JpaUtil.getEntityManager();
	            transaction = entityManager.getTransaction();
	            transaction.begin();

	            // Check if the employee with the given ID already exists
	            Employees existingEmployee = entityManager.find(Employees.class, id);

	            if (existingEmployee == null) {
	                // If employee doesn't exist, insert as a new entry
	                Employees employee = new Employees();
	                employee.setId(id);
	                employee.setName(name);
	                employee.setPhone(phone);
	                employee.setEmail(email);
	                employee.setAddress(address);

	                entityManager.persist(employee);
	                System.out.println("Employee inserted successfully with ID: " + id);
	            } else {
	                // If employee exists, update the entry instead of persisting
	                existingEmployee.setName(name);
	                existingEmployee.setPhone(phone);
	                existingEmployee.setEmail(email);
	                existingEmployee.setAddress(address);

	                entityManager.merge(existingEmployee);
	                System.out.println("Employee with ID: " + id + " already exists, updated instead.");
	            }

	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (entityManager != null && entityManager.isOpen()) {
	                entityManager.close(); // Ensure the EntityManager is closed
	            }
	        }
	 }

    // Fetch an employee by ID
    public Employees fetch(int id) {
        EntityManager entityManager = null;
        Employees employee = null;
        try {
            entityManager = JpaUtil.getEntityManager();
            entityManager.getTransaction().begin();

            employee = entityManager.find(Employees.class, id);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Ensure the EntityManager is closed
            }
        }
        return employee;
    }

    // Update an existing employee
    public void update(int id, String name, String phone, String email, String address) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JpaUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Employees employee = entityManager.find(Employees.class, id);
            if (employee != null) {
                employee.setName(name);
                employee.setPhone(phone);
                employee.setEmail(email);
                employee.setAddress(address);

                // Use merge() to update an existing entity
                entityManager.merge(employee);
                System.out.println("Employee updated successfully with ID: " + id);
            } else {
                System.out.println("Employee not found for update with ID: " + id);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Ensure the EntityManager is closed
            }
        }
    }

    // Delete an employee by ID
    public void delete(int id) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JpaUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Employees employee = entityManager.find(Employees.class, id);
            if (employee != null) {
                entityManager.remove(employee);
                System.out.println("Employee deleted successfully with ID: " + id);
            } else {
                System.out.println("Employee not found for deletion with ID: " + id);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Ensure the EntityManager is closed
            }
        }
    }
}
