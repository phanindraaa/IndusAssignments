package com.indus.training.spring.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_emails", joinColumns = @JoinColumn(name = "customer_id"))
    @MapKeyColumn(name = "email_type")
    @Column(name = "email_address")
    private Map<String, String> additionalEmails = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_phone_numbers", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "phone_number")
    private List<String> phoneNumbers = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_addresses", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "address")
    private Set<String> addresses = new HashSet<>();

//    @ElementCollection(target)
//    @CollectionTable(name = "customer_preferences", joinColumns = @JoinColumn(name = "customer_id"))
//    @MapKeyColumn(name = "preference_key")
//    @Column(name = "preference_value")
//    private Properties preferences = new Properties();

    // Getters and setters for new fields
    public Map<String, String> getAdditionalEmails() {
        return additionalEmails;
    }

    public void setAdditionalEmails(Map<String, String> additionalEmails) {
        this.additionalEmails = additionalEmails;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }

//    public Properties getPreferences() {
//        return preferences;
//    }
//
//    public void setPreferences(Properties preferences) {
//        this.preferences = preferences;
//    }
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
