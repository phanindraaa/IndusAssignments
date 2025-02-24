package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddressDao {

    public void saveAddress(Address address) {
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

    public Address getAddressById(Long addressId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Address) session.get(Address.class, addressId);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public List<Employee> getEmployeesByAddressId(Long addressId) {
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            Address address = (Address) session.get(Address.class, addressId);
//            return address.getEmployees();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
    
//    public List<Employee> getEmployeesByAddressId(Long addressId) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        String hql = "FROM Employee e WHERE e.address.addressID = :addressId";
//        @SuppressWarnings("unchecked")
//		List<Employee> employees = session.createQuery(hql)
//                                          .setParameter("addressId", addressId)
//                                          .list();
//        session.close();
//        return employees;
//    }
//

    public Map<Long, Employee> getEmployeesByAddressId(Long addressId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Address address = (Address) session.get(Address.class, addressId);
            if (address != null) {
                Hibernate.initialize(address.getEmployees()); // Force initialization
                return address.getEmployees();
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }




    public void deleteAddress(Long addressId) {
        Session session = null;
        Transaction transaction = null;
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
