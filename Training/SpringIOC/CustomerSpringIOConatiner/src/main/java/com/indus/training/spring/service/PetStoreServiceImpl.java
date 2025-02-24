package com.indus.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indus.training.spring.entity.Customers;
import com.indus.training.spring.svc.CustomerDAO;
import com.indus.training.spring.svc.OrderDAO;

import java.util.List;
import java.util.stream.Collectors;

@Service("petStore")
@EnableJpaRepositories(basePackages = "com.indus.training.spring.svc")

public class PetStoreServiceImpl implements PetStoreService {

    private CustomerDAO customerDAO;

    // Setter method for customerDAO
    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    
    private OrderDAO orderDAO;

    // Setter method for customerDAO
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
}
