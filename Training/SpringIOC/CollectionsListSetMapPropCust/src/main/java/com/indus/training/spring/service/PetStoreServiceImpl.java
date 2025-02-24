package com.indus.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indus.training.spring.entity.Customers;
import com.indus.training.spring.entity.Orders;
import com.indus.training.spring.svc.CustomerDAO;
import com.indus.training.spring.svc.OrderDAO;

import java.util.*;
import java.util.stream.Collectors;

@Service("petStore")
public class PetStoreServiceImpl implements PetStoreService {

    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Transactional
    @Override
    public void addCustomer(Customers customer) {
        customerDAO.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getUsernameList() {
        List<Customers> customers = customerDAO.findAll();
        return customers.stream().map(Customers::getCustomerName).collect(Collectors.toList());
    }
    

    @Transactional(readOnly = true)
    @Override
    public Customers getCustomerById(int customerId) {
        return customerDAO.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
    }

  
}