package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.indus.training.persist.util.HibernateUtil;

public class EmployeeDAO {

	public void saveEmployee(Employee employee) {
	    Transaction transaction = null;
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();

	        // Save the address first (if it's not yet persisted)
	        if (employee.getAddress() != null && employee.getAddress().getAddressID() == null) {
	            session.save(employee.getAddress());  // Save the address
	        }

	        // Now save the employee
	        session.save(employee);

	        session.flush();  // Ensure everything is written to the DB
	        transaction.commit();  // Commit the transaction

	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();  // Rollback in case of an error
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();  // Close the session in the finally block to ensure it's always closed
	        }
	    }
	}


    public Employee getEmployee(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Employee) session.get(Employee.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteEmployee(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
