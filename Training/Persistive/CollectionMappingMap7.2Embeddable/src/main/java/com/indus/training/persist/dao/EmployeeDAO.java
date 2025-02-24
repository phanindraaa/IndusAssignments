package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public final class EmployeeDAO {

    public final void saveEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(employee);
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

    public final Employee getEmployeeById(Long employeeID) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Employee) session.get(Employee.class, employeeID);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public final List<Employee> getAllEmployees() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Employee");
            return query.list();  // No need for explicit casting in this case
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public final void deleteEmployee(Long employeeID) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeID);
            if (employee != null) {
                session.delete(employee);
            }
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

    public final void updateEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(employee);
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
