package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Address;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SQLQuery;

public class AddressDao {

    // Custom SQL for Save
    public void saveAddress(Address address) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Use native SQL for inserting an address
            String sql = "INSERT INTO Address (Street, City, Country) VALUES (:street, :city, :country)";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("street", address.getStreet());
            query.setParameter("city", address.getCity());
            query.setParameter("country", address.getCountry());
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
    public void updateAddress(Address address) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Use native SQL for updating an address
            String sql = "UPDATE Address SET Street = :street, City = :city, Country = :country WHERE AddressID = :addressID";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("street", address.getStreet());
            query.setParameter("city", address.getCity());
            query.setParameter("country", address.getCountry());
            query.setParameter("addressID", address.getAddressID());
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
    public void deleteAddress(Long addressID) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Use native SQL for deleting an address
            String sql = "DELETE FROM Address WHERE AddressID = :addressID";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("addressID", addressID);
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
    public Address getAddress(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            // Use native SQL for selecting an address
            String sql = "SELECT * FROM Address WHERE AddressID = :id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Address.class);
            query.setParameter("id", id);
            return (Address) query.uniqueResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
