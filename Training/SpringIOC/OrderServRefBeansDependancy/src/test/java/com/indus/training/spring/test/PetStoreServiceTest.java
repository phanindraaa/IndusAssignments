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
import com.indus.training.spring.entity.Orders;
import com.indus.training.spring.service.OrderService;
import com.indus.training.spring.service.PetStoreService;
import com.indus.training.spring.service.PetStoreServiceImpl;

public class PetStoreServiceTest {

    private PetStoreService petStoreService;
    private OrderService orderService;
    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:services.xml", "classpath:daos.xml");
        petStoreService = context.getBean("petStore", PetStoreService.class);
        orderService = context.getBean("orderService", OrderService.class);
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
//        assertEquals(1, userList.size());
        assertEquals("John Doe", userList.get(0));
    }
    
    @Test
    public void testCreateOrderAndRetrieve() {
        Customers customer = new Customers();
        customer.setCustomerName("Jane Doe");
        customer.setEmail("jane.doe@example.com");
        petStoreService.addCustomer(customer);

        Orders order = new Orders();
        order.setCustomer(customer);
        order.setOrderDescription("Test Order");
        orderService.createOrder(order);

        List<Orders> customerOrders = orderService.getOrdersForCustomer(customer.getCustomerId());
        assertNotNull(customerOrders);
        assertEquals(1, customerOrders.size());
        assertEquals("Test Order", customerOrders.get(0).getOrderDescription());
    }
}
