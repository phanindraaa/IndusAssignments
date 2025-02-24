package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

import java.util.List;

public class EmployeeDAO {

    public void batchInsertEmployees(List<Employee> employees) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        int batchSize = 20; // Adjust as needed
        for (int i = 0; i < employees.size(); i++) {
            session.save(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                session.flush();
                session.clear();
            }
        }

        tx.commit();
        session.close();
    }

    public void batchUpdateEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        ScrollableResults results = session.createQuery("from Employee").scroll(ScrollMode.FORWARD_ONLY);
        int count = 0;
        int batchSize = 20;

        while (results.next()) {
            Employee employee = (Employee) results.get(0);
            employee.setLastName("UpdatedLastName");
            session.update(employee);

            if (++count % batchSize == 0) {
                session.flush();
                session.clear();
            }
        }

        tx.commit();
        session.close();
    }

    public void batchDeleteEmployeesByLastName(String lastName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        String hqlDelete = "delete from Employee e where e.lastName = :lastName";
        session.createQuery(hqlDelete)
                .setParameter("lastName", lastName)
                .executeUpdate();

        tx.commit();
        session.close();
    }
}
