package com.indus.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indus.training.spring.entity.Customers;
import com.indus.training.spring.svc.CustomerDAO;
import com.indus.training.spring.svc.OrderDAO;

import java.util.List;
import java.util.stream.Collectors;

@Service("petStoreService")
public class PetStoreServiceImpl implements PetStoreService {

    private final CustomerDAO customerDAO;
    private final OrderDAO orderDAO;

    @Autowired
    public PetStoreServiceImpl(CustomerDAO customerDAO, OrderDAO orderDAO) {
        this.customerDAO = customerDAO;
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
}
