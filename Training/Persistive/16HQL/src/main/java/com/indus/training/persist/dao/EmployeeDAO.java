package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {

    public void saveEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteEmployee(Long long1) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, long1);
            if (employee != null) {
                session.delete(employee);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Employee getEmployee(Long long1) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = null;
        try {
            employee = (Employee) session.createQuery("FROM Employee e WHERE e.employeeID = :employeeId")
                                          .setParameter("employeeId", long1)
                                          .uniqueResult();
        } finally {
            session.close();
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = null;
        try {
            employees = session.createQuery("FROM Employee").list();
        } finally {
            session.close();
        }
        return employees;
    }
}
