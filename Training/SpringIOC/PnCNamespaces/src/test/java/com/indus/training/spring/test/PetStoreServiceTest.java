package com.indus.training.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indus.training.spring.entity.Customers;
import com.indus.training.spring.service.PetStoreService;
import com.indus.training.spring.service.CustomerService;

public class PetStoreServiceTest {

    private PetStoreService petStoreService;
    private CustomerService customerService;
    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:services.xml", "classpath:daos.xml");
        petStoreService = context.getBean("petStore", PetStoreService.class);
        customerService = context.getBean("customerService", CustomerService.class);
    }

    @After
    public void tearDown() {
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testAddCustomerAndRetrieve() {
        Customers customer = new Customers();
        customer.setCustomerName("John Doe");
        customer.setEmail("john.doe@example.com");

        petStoreService.addCustomer(customer);

        List<String> userList = petStoreService.getUsernameList();
        assertEquals("John Doe", userList.get(userList.size() - 1));

        List<Customers> allCustomers = customerService.getAllCustomers();
        assertNotNull(allCustomers);
        assertTrue(allCustomers.size() > 0);

        Customers retrievedCustomer = customerService.getCustomerById(customer.getCustomerId());
        assertNotNull(retrievedCustomer);
        assertEquals("John Doe", retrievedCustomer.getCustomerName());
    }
}