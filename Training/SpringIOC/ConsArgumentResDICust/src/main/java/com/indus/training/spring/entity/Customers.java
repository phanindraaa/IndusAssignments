package com.indus.training.spring.entity;

import java.beans.ConstructorProperties;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "email")
    private String email;
    
    
    protected Customers() {}
    
    @ConstructorProperties({"customerName", "email"})
    public Customers(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
