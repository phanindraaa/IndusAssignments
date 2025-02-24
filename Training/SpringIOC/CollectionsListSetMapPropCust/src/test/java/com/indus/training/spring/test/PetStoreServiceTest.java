package com.indus.training.spring.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indus.training.spring.entity.Customers;
import com.indus.training.spring.entity.Orders;
import com.indus.training.spring.service.PetStoreService;
import com.indus.training.spring.service.PetStoreServiceImpl;

public class PetStoreServiceTest {

    private PetStoreService petStoreService;
    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:services.xml", "classpath:daos.xml");
        petStoreService = context.getBean("petStore", PetStoreServiceImpl.class);
    }

    @After
    public void tearDown() {
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testAddCustomerAndRetrieve() {
        Customers customer = new Customers();
        customer.setCustomerName("Phani");
        customer.setEmail("phani@gmail.com");

        petStoreService.addCustomer(customer);

        List<String> userList = petStoreService.getUsernameList();
        assertTrue(userList.contains("Phani"));
    }

    @Test
    public void testCustomerCollections() {
        Customers customer = context.getBean("exampleCustomer", Customers.class);
        
        // Verify the collections are set correctly
        Map<String, String> emails = customer.getAdditionalEmails();
        assertEquals(2, emails.size());
        assertEquals("phani.work@example.com", emails.get("work"));
        assertEquals("phani.personal@example.com", emails.get("personal"));

        List<String> phoneNumbers = customer.getPhoneNumbers();
        assertEquals(2, phoneNumbers.size());
        assertTrue(phoneNumbers.contains("123-456-7890"));
        assertTrue(phoneNumbers.contains("987-654-3210"));

        Set<String> addresses = customer.getAddresses();
        assertEquals(2, addresses.size());
        assertTrue(addresses.contains("Ohio"));
        assertTrue(addresses.contains("Dayton"));

//        Properties preferences = customer.getPreferences();
//        assertEquals(2, preferences.size());
//        assertEquals("yes", preferences.getProperty("newsletter"));
//        assertEquals("English", preferences.getProperty("language"));

        // Add the customer to the database
        petStoreService.addCustomer(customer);

        // Retrieve the customer and verify collections are persisted
        Customers retrievedCustomer = petStoreService.getCustomerById(customer.getCustomerId());

        assertNotNull(retrievedCustomer);
        assertEquals(2, retrievedCustomer.getAdditionalEmails().size());
        assertEquals("phani.work@example.com", retrievedCustomer.getAdditionalEmails().get("work"));
        assertEquals(2, retrievedCustomer.getPhoneNumbers().size());
        assertTrue(retrievedCustomer.getPhoneNumbers().contains("123-456-7890"));
        assertEquals(2, retrievedCustomer.getAddresses().size());
        assertTrue(retrievedCustomer.getAddresses().contains("Ohio"));
//        assertEquals("yes", retrievedCustomer.getPreferences().getProperty("newsletter"));
    }
}