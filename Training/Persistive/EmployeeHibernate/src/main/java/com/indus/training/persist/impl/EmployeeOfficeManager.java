package com.indus.training.persist.impl;

import com.indus.training.persist.dao.IEmployeeOffice;
import com.indus.training.persist.entity.EmployeeOffice;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class EmployeeOfficeManager implements IEmployeeOffice {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void insert(EmployeeOffice office) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(office);
            session.getTransaction().commit();
            System.out.println("Office inserted successfully with ID: " + office.getOfficeId());
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public EmployeeOffice fetch(int officeId) {
        Session session = sessionFactory.getCurrentSession();
        EmployeeOffice office = null;
        try {
            session.beginTransaction();
            office = (EmployeeOffice) session.get(EmployeeOffice.class, officeId);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return office;
    }

    @Override
    public void update(EmployeeOffice office) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(office);
            session.getTransaction().commit();
            System.out.println("Office updated successfully with ID: " + office.getOfficeId());
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int officeId) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            EmployeeOffice office = (EmployeeOffice) session.get(EmployeeOffice.class, officeId);
            if (office != null) {
                session.delete(office);
                System.out.println("Office deleted successfully with ID: " + officeId);
            } else {
                System.out.println("Office not found for deletion with ID: " + officeId);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

  
}
