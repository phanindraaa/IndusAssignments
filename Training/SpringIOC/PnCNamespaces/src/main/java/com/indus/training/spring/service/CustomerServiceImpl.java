package com.indus.training.spring.service;

import com.indus.training.spring.entity.Customers;
import com.indus.training.spring.svc.CustomerDAO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customers> getAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public Customers getCustomerById(int id) {
        return customerDAO.findById(id).orElse(null);
    }
}