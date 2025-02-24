package com.indus.training.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indus.training.spring.entity.Customers;
import com.indus.training.spring.service.PetStoreService;

public class PetStoreServiceTest {

    private PetStoreService petStoreService;
    private ApplicationContext context;

    @Before
    public void setUp() {
        // Initialize the Spring ApplicationContext before each test
        context = new ClassPathXmlApplicationContext("classpath:services.xml", "classpath:daos.xml");

        petStoreService = context.getBean("petStore", PetStoreService.class);
    }

    @After
    public void tearDown() {
        // Clean up after each test
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testAddCustomerAndRetrieve() {
        Customers customer = new Customers();
        customer.setCustomerName("John Doe");
        customer.setEmail("john.doe@example.com");

        // Adding a customer to the database
        petStoreService.addCustomer(customer);

        // Retrieving the list of usernames
        List<String> userList = petStoreService.getUsernameList();
        
        // Assert that the list is not empty
        assertTrue("User list should not be empty", !userList.isEmpty());
        
        // Assert that the added customer's name is in the list
        assertTrue("Added customer should be in the list", userList.contains("John Doe"));
    }

    @Test
    public void testMultipleCustomers() {
        Customers customer1 = new Customers();
        customer1.setCustomerName("Alice Smith");
        customer1.setEmail("alice.smith@example.com");

        Customers customer2 = new Customers();
        customer2.setCustomerName("Bob Johnson");
        customer2.setEmail("bob.johnson@example.com");

        petStoreService.addCustomer(customer1);
        petStoreService.addCustomer(customer2);

        List<String> userList = petStoreService.getUsernameList();
        
        assertEquals("Should have at least 2 customers", 2, userList.size());
        assertTrue("Alice should be in the list", userList.contains("Alice Smith"));
        assertTrue("Bob should be in the list", userList.contains("Bob Johnson"));
    }
}