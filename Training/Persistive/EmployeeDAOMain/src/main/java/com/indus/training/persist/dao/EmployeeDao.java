package com.indus.training.persist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.indus.training.persist.util.HibernateUtil;

import com.indus.training.persist.entity.Employees;

public class EmployeeDao {
	
	private EntityManagerFactory entityManagerFactory;
	
	public EmployeeDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("myPersistJpa");
	}
	
	
	public void save(Employees employee) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}	
	
	public Employees findById(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employees employee = entityManager.find(Employees.class, id);
		entityManager.close();
		return employee;
		
	}
	
	public List<Employees> getAllEmployees(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Employees> query = entityManager.createQuery("SELECT e from Employees e", Employees.class);
		List<Employees> employees = query.getResultList();
		entityManager.close();
		return employees;
		
	}
	
	public void update(Employees employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void delete(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employees employee = entityManager.find(Employees.class, id);
		if (employee!= null) {
			entityManager.remove(employee);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
