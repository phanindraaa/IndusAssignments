package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class EmployeeDAO {

    // Persistent Object (save)
	public void saveEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Ensure address is not null
            if (employee.getAddress() == null) {
                throw new IllegalArgumentException("Employee address cannot be null");
            }

            session.save(employee);  // Save the employee (cascade will handle Address)
            transaction.commit();

            // Confirm the generated ID
            System.out.println("Generated Employee ID: " + employee.getEmployeeID());

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    public Employee getEmployeeById(Long employeeID) {
        Session session = null;
        Employee employee = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            if (employeeID == null) {
                throw new IllegalArgumentException("Employee ID cannot be null when loading");
            }

            employee = (Employee) session.get(Employee.class, employeeID);

        } finally {
            if (session != null) session.close();
        }
        return employee;
    }


    // Load Employee
    public Employee loadEmployee(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.load(Employee.class, id);  // TAG: Hibernate load()
            transaction.commit();
            return employee;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) session.close();  // TAG: finally method for closing session
        }
    }

    // Querying (HQL)
    public List<Employee> queryEmployeeByName(String name) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            // Updated to use createQuery(String)
            Query query = session.createQuery("from Employee e where e.firstName = :name");  // TAG: Bind parameter
            query.setParameter("name", name);
            
            // Need to cast the result explicitly
            List<Employee> employees = query.list();
            transaction.commit();
            return employees;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    // Scrollable iteration (HQL)
    public void iterateEmployees() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            // Updated to use createQuery(String)
            Query query = session.createQuery("from Employee e order by e.lastName");
            Iterator<Employee> iter = query.iterate();  // TAG: Scrollable iteration
            
            while (iter.hasNext()) {
                Employee employee = (Employee) iter.next();
                System.out.println("Iterated Employee: " + employee.getFirstName());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    // Pagination
    public List<Employee> paginateEmployees(int pageNumber, int pageSize) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            // Updated to use createQuery(String)
            Query query = session.createQuery("from Employee");
            query.setFirstResult((pageNumber - 1) * pageSize);  // TAG: Pagination start
            query.setMaxResults(pageSize);  // TAG: Pagination limit
            
            List<Employee> employees = query.list();
            transaction.commit();
            return employees;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    // Modifying (flush)
    public void updateEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            employee.setFirstName("UpdatedName");  // Modifying object
            session.flush();  // TAG: Flushing session
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    // Deleting an employee
    public void deleteEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(employee);  // TAG: Deleting object
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
