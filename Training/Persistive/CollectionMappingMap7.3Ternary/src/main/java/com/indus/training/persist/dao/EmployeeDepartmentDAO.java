package com.indus.training.persist.dao;

import com.indus.training.persist.entity.EmployeeDepartment;
import com.indus.training.persist.entity.EmployeeDepartmentId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDepartmentDAO {

    private SessionFactory sessionFactory;

    public EmployeeDepartmentDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void save(EmployeeDepartment employeeDepartment) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(employeeDepartment);
            transaction.commit();
        } catch (HibernateException e) {
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

    public EmployeeDepartment findById(EmployeeDepartmentId id) {
        Session session = null;
        EmployeeDepartment employeeDepartment = null;
        try {
            session = sessionFactory.openSession();
            employeeDepartment = (EmployeeDepartment) session.get(EmployeeDepartment.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return employeeDepartment;
    }

    public void update(EmployeeDepartment employeeDepartment) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(employeeDepartment);
            transaction.commit();
        } catch (HibernateException e) {
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

    public void delete(EmployeeDepartmentId id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            EmployeeDepartment employeeDepartment = (EmployeeDepartment) session.get(EmployeeDepartment.class, id);
            if (employeeDepartment != null) {
                session.delete(employeeDepartment);
                transaction.commit();
            }
        } catch (HibernateException e) {
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
