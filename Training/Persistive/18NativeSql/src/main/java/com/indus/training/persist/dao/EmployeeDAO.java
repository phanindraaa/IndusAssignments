package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SQLQuery;

public class EmployeeDAO {

    // Custom SQL for Save
    public void saveEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Use native SQL for inserting an employee
            String sql = "INSERT INTO Employee (FirstName, LastName, AddressID) VALUES (:firstName, :lastName, :addressID)";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("firstName", employee.getFirstName());
            query.setParameter("lastName", employee.getLastName());
            query.setParameter("addressID", employee.getAddress().getAddressID());
            query.executeUpdate();

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

    // Custom SQL for Update
    public void updateEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Use native SQL for updating an employee
            String sql = "UPDATE Employee SET FirstName = :firstName, LastName = :lastName, AddressID = :addressID WHERE EmployeeID = :employeeID";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("firstName", employee.getFirstName());
            query.setParameter("lastName", employee.getLastName());
            query.setParameter("addressID", employee.getAddress().getAddressID());
            query.setParameter("employeeID", employee.getEmployeeID());
            query.executeUpdate();

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

    // Custom SQL for Delete
    public void deleteEmployee(Long employeeID) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Use native SQL for deleting an employee
            String sql = "DELETE FROM Employee WHERE EmployeeID = :employeeID";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("employeeID", employeeID);
            query.executeUpdate();

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

    // Custom SQL for Select
    public Employee getEmployee(Long employeeID) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            // Use native SQL for selecting an employee
            String sql = "SELECT * FROM Employee WHERE EmployeeID = :employeeID";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Employee.class); // Specify the entity class for result mapping
            query.setParameter("employeeID", employeeID);
            return (Employee) query.uniqueResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
