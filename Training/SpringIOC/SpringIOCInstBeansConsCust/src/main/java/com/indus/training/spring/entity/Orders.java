package com.indus.training.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @Column(name = "order_description")
    private String orderDescription;
    
    // Default constructor (required by JPA)
    public Orders() {}

    // Constructor for dependency injection
    public Orders(Customers customer, String orderDescription) {
        this.customer = customer;
        this.orderDescription = orderDescription;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
