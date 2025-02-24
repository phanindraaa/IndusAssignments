package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeDaoTest {

    private static EmployeeDAO employeeDAO;

    @BeforeAll
    public static void setUp() {
        employeeDAO = new EmployeeDAO();
    }

    @Test
    public void testBatchInsertEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            employee.setFirstName("First" + i);
            employee.setLastName("Last" + i);
            Address address = new Address();
            address.setStreet("Street " + i);
            address.setCity("City " + i);
            address.setCountry("Country " + i);
            employee.setAddress(address);
            employees.add(employee);
        }

        employeeDAO.batchInsertEmployees(employees);

        // Verify that the employees were inserted
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            long count = (long) session.createQuery("select count(e) from Employee e").uniqueResult();
            assertEquals(100, count); // Expecting 100 employees
        } finally {
            session.close();
        }
    }

    @Test
    public void testBatchUpdateEmployees() {
        // First, insert employees to update
        testBatchInsertEmployees();

        // Now, update the employees
        employeeDAO.batchUpdateEmployees();

        // Verify that the employees were updated
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Employee> employees = session.createQuery("from Employee").list();
            for (Employee employee : employees) {
                assertNotNull(employee.getLastName()); // Ensure last name was updated
            }
        } finally {
            session.close();
        }
    }

    @Test
    public void testBatchDeleteEmployeesByLastName() {
        // First, insert employees to delete
        testBatchInsertEmployees();

        // Delete employees with the last name "Last0"
        employeeDAO.batchDeleteEmployeesByLastName("Last0");

        // Verify that the employee was deleted
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            long count = (long) session.createQuery("select count(e) from Employee e where e.lastName = 'Last0'").uniqueResult();
            assertEquals(0, count); // Expecting 0 employees with last name "Last0"
        } finally {
            session.close();
        }
    }

    @AfterAll
    public static void tearDown() {
        HibernateUtil.shutdown();
    }
}
