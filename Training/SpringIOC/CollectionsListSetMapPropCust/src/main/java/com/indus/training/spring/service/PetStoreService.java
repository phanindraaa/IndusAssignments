package com.indus.training.spring.service;

import java.util.List;
import com.indus.training.spring.entity.Customers;

public interface PetStoreService {
    void addCustomer(Customers customer);
    List<String> getUsernameList();
    Customers getCustomerById(int customerId);
}