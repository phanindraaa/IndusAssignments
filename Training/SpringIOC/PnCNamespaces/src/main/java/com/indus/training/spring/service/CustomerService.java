package com.indus.training.spring.service;

import com.indus.training.spring.entity.Customers;
import java.util.List;

public interface CustomerService {
    List<Customers> getAllCustomers();
    Customers getCustomerById(int id);
}