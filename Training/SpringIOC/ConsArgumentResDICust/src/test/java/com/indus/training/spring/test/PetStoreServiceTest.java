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

    private PetStoreService petStoreService;
    private ApplicationContext context;

    @Before
    public void setUp() {
        // Initialize the Spring ApplicationContext before each test
        context = new ClassPathXmlApplicationContext("classpath:services.xml", "classpath:daos.xml");

        petStoreService = context.getBean("petStore", PetStoreServiceImpl.class);
    }

    @After
    public void tearDown() {
        // Clean up after each test
        ((ClassPathXmlApplicationContext) context).close();
    }
    @Test
    public void testAddCustomerAndRetrieve() {
        Customers customer = new Customers("Alice Wonder", "alice.wonder@example.com");
        petStoreService.addCustomer(customer);

        List<String> userList = petStoreService.getUsernameList();
        assertEquals("Alice Wonder", userList.get(userList.size() - 1));
    }

    @Test
    public void testConstructorInjectedBeans() {
        Customers customer1 = context.getBean("customer1", Customers.class);
        Customers customer2 = context.getBean("customer2", Customers.class);
        Customers customer3 = context.getBean("customer3", Customers.class);

        assertNotNull(customer1);
        assertEquals("John Doe", customer1.getCustomerName());

        assertNotNull(customer2);
        assertEquals("Jane Smith", customer2.getCustomerName());

        assertNotNull(customer3);
        assertEquals("Bob Johnson", customer3.getCustomerName());
    }
}
