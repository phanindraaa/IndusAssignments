package com.indus.training.persist.impl;

import org.hibernate.Session;

import com.indus.training.persist.dao.IEmployeeManager;
import com.indus.training.persist.entity.Employees;
import com.indus.training.persist.util.HibernateUtil;

public class EmployeeManager implements IEmployeeManager {

	@Override
	public void insert(int id, String name, String phone, String email, String address) {
		// TODO Auto-generated method stub
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        
	        Employees employee = new Employees();
	        employee.setId(id);  
	        employee.setName(name);
	        employee.setPhone(phone);
	        employee.setEmail(email);
	        employee.setAddress(address);
	        session.save(employee);

	        session.getTransaction().commit();
	        System.out.println("Employee inserted successfully with ID: " + id);

	}

	@Override
	public Employees fetch(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Employees employee = (Employees) session.get(Employees.class, id);
        session.getTransaction().commit();

        return employee;

	}

	@Override
	public void update(int id, String name, String phone, String email, String address) {
		// TODO Auto-generated method stub
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	
	        Employees employee = (Employees) session.get(Employees.class, id);
	        if (employee != null) {
	            employee.setName(name);
	            employee.setPhone(phone);
	            employee.setEmail(email);
	            employee.setAddress(address);
	            session.update(employee);
	            System.out.println("Employee updated successfully with ID: " + id);
	        } else {
	            System.out.println("Employee not found for update with ID: " + id);
	        }
	
	        session.getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();

	        Employees employee = (Employees) session.get(Employees.class, id);
	        if (employee != null) {
	            session.delete(employee);
	            System.out.println("Employee deleted successfully with ID: " + id);
	        } else {
	            System.out.println("Employee not found for deletion with ID: " + id);
	        }

	        session.getTransaction().commit();
	    }

}
