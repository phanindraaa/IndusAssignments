package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

    // Method to save Employee and the associated Address in a One-to-One relationship
    public void saveEmployee(Employee employee) {
        Transaction transaction = null;
        Session session = null;

        try {
            // Get the current session
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Save the address first, if it's not already persisted
            Address address = employee.getAddress();
            if (address != null && address.getAddressID() == null) {
                session.save(address);
            }

            // Save the employee with the foreign key relationship
            session.save(employee);

            // Commit the transaction
            transaction.commit();
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

    // Method to get an Employee by ID
    public Employee getEmployee(Long employeeId) {
        Session session = null;
        try {
            // Open a new session
            session = HibernateUtil.getSessionFactory().openSession();
            return (Employee) session.get(Employee.class, employeeId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Method to delete an Employee by ID
    public void deleteEmployee(Long employeeId) {
        Transaction transaction = null;
        Session session = null;

        try {
            // Open session and start transaction
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Fetch the employee to be deleted
            Employee employee = (Employee) session.get(Employee.class, employeeId);
            if (employee != null) {
                session.delete(employee);  // Deleting the employee will also handle the address deletion due to cascade
            }

            // Commit the transaction
            transaction.commit();
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

