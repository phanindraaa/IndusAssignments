package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

    public void saveEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Save the address first (if it's not yet persisted)
            if (employee.getAddress() != null && employee.getAddress().getAddressID() == null) {
                session.save(employee.getAddress());  // Save the address
            }

            // Now save the employee
            session.save(employee);

            transaction.commit();  // Commit the transaction

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback in case of an error
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();  // Close the session in the finally block to ensure it's always closed
            }
        }
    }
    
    public Employee getEmployeeById(Set<Employee> employees, Long employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeId)) {
                return employee;
            }
        }
        return null; // Or throw an exception if not found
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
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
