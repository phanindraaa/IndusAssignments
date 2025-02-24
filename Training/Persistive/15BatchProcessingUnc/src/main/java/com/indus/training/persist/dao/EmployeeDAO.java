package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;  // Import this for Hibernate 5 or later

import java.util.List;

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
            if (session != null) {
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
            if (session != null) {
                session.close();
            }
        }
    }

    // Example of batch insert
    public void batchInsertEmployees(List<Employee> employees) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < employees.size(); i++) {
                session.save(employees.get(i));
                if (i % 20 == 0) { // Flush a batch of inserts and release memory
                    session.flush();
                    session.clear();
                }
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    // Example of batch update
    public void batchUpdateEmployees(List<Employee> employees) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < employees.size(); i++) {
                session.update(employees.get(i));
                if (i % 20 == 0) { // Flush a batch of updates and release memory
                    session.flush();
                    session.clear();
                }
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
