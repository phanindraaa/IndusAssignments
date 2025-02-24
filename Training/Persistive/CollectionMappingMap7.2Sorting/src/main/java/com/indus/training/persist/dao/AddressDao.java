package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public final class AddressDao {

    public final void saveAddress(Address address) {
        Session session = null;
        Transaction transaction = null;
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

    public final Address getAddressById(Long addressID) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Address) session.get(Address.class, addressID);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public final void saveEmployeeWithAddress(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Save the address first, if not already saved
            Address address = employee.getAddress();
            if (address != null && address.getAddressID() == null) {
                session.save(address);  // Save the address
            }

            session.save(employee);  // Now save the employee
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
