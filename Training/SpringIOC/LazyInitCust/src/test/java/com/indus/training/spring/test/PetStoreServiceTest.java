package com.indus.training.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indus.training.spring.entity.Customers;
import com.indus.training.spring.service.PetStoreService;
import com.indus.training.spring.service.PetStoreServiceImpl;

public class PetStoreServiceTest {

    private ApplicationContext context;

    @Before
    public void setUp() {
        // Initialize the Spring ApplicationContext before each test
        context = new ClassPathXmlApplicationContext("classpath:services.xml", "classpath:daos.xml");
    }

    @After
    public void tearDown() {
        // Clean up after each test
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testLazyInitialization() {
        System.out.println("Before getting petStore bean");
        PetStoreService petStoreService = context.getBean("petStore", PetStoreServiceImpl.class);
        System.out.println("After getting petStore bean");
        assertNotNull(petStoreService);
    }

    @Test
    public void testAddCustomerAndRetrieve() {
        PetStoreService petStoreService = context.getBean("petStore", PetStoreServiceImpl.class);
        
        Customers customer = new Customers();
        customer.setCustomerName("John Doe");
        customer.setEmail("john.doe@example.com");

        // Adding a customer to the database
        petStoreService.addCustomer(customer);

        // Retrieving the list of usernames
        List<String> userList = petStoreService.getUsernameList();
        assertEquals("John Doe", userList.get(0));
    }
}