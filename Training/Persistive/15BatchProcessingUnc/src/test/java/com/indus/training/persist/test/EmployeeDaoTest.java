package com.indus.training.persist.test;

import com.indus.training.persist.dao.EmployeeDAO;
import com.indus.training.persist.entity.Address;
import com.indus.training.persist.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoTest {

    private EmployeeDAO employeeDAO;

    @BeforeEach
    public void setUp() {
        employeeDAO = new EmployeeDAO();
    }

    @Test
    public void testSaveEmployee() {
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("Anytown");
        address.setCountry("USA");

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setAddress(address);

        employeeDAO.saveEmployee(employee);

        // Validate that the employee was saved (retrieve it back)
        Employee retrieved = employeeDAO.getEmployee(employee.getEmployeeID());
        assertNotNull(retrieved);
        assertEquals("John", retrieved.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        Address address = new Address();
        address.setStreet("456 Elm St");
        address.setCity("Othertown");
        address.setCountry("USA");

        Employee employee = new Employee();
        employee.setFirstName("Jane");
        employee.setLastName("Doe");
        employee.setAddress(address);

        employeeDAO.saveEmployee(employee);
        Long employeeId = employee.getEmployeeID();

        // Delete the employee
        employeeDAO.deleteEmployee(employeeId);

        // Validate that the employee was deleted
        assertNull(employeeDAO.getEmployee(employeeId));
    }

    @Test
    public void testBatchInsertEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Address address = new Address();
            address.setStreet("Street " + i);
            address.setCity("City " + i);
            address.setCountry("Country " + i);

            Employee employee = new Employee();
            employee.setFirstName("First " + i);
            employee.setLastName("Last " + i);
            employee.setAddress(address);
            employees.add(employee);
        }

        employeeDAO.batchInsertEmployees(employees);

        // Validate that all employees were inserted
        for (Employee employee : employees) {
            Employee retrieved = employeeDAO.getEmployee(employee.getEmployeeID());
            assertNotNull(retrieved);
            assertEquals(employee.getFirstName(), retrieved.getFirstName());
        }
    }

    @Test
    public void testBatchUpdateEmployees() {
        // First, insert some employees
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Address address = new Address();
            address.setStreet("Street " + i);
            address.setCity("City " + i);
            address.setCountry("Country " + i);

            Employee employee = new Employee();
            employee.setFirstName("First " + i);
            employee.setLastName("Last " + i);
            employee.setAddress(address);
            employees.add(employee);
            employeeDAO.saveEmployee(employee);
        }

        // Now, update their names
        for (Employee employee : employees) {
            employee.setFirstName(employee.getFirstName() + " Updated");
        }

        employeeDAO.batchUpdateEmployees(employees);

        // Validate that all employees were updated
        for (Employee employee : employees) {
            Employee updated = employeeDAO.getEmployee(employee.getEmployeeID());
            assertNotNull(updated);
            assertTrue(updated.getFirstName().endsWith("Updated"));
        }
    }
}
