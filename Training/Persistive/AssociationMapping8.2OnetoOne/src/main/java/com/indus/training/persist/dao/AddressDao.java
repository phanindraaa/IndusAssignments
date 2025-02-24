package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Map;

public class AddressDao {

    // Save an Address
    public void saveAddress(Address address) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(address);
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

    // Get an Address by ID
    public Address getAddressById(Long addressId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Address) session.get(Address.class, addressId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Get Employees by Address ID
    public Map<Long, Employee> getEmployeesByAddressId(Long addressId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Address address = (Address) session.get(Address.class, addressId);

            // Initialize the employees collection to avoid lazy loading issues
            if (address != null) {
                Hibernate.initialize(address.getEmployees());
                return address.getEmployees();  // Returns the map of Employee objects
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Delete an Address by ID
    public void deleteAddress(Long addressId) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Address address = (Address) session.get(Address.class, addressId);
            if (address != null) {
                session.delete(address);
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
}
