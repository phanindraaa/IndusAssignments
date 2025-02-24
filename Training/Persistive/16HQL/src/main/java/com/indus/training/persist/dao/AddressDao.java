package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Address;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressDao {

    public void saveAddress(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(address);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateAddress(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(address);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteAddress(Long long1) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Address address = (Address) session.get(Address.class, long1);
            if (address != null) {
                session.delete(address);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Address getAddress(Long long1) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Address address = null;
        try {
            address = (Address) session.createQuery("FROM Address a WHERE a.addressID = :addressId")
                                       .setParameter("addressId", long1)
                                       .uniqueResult();
        } finally {
            session.close();
        }
        return address;
    }

    public List<Address> getAllAddresses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Address> addresses = null;
        try {
            addresses = session.createQuery("FROM Address").list();
        } finally {
            session.close();
        }
        return addresses;
    }
}
