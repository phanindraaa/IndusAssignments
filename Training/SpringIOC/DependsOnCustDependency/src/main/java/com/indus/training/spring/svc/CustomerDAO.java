package com.indus.training.spring.svc;

import com.indus.training.spring.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customers, Integer> {
    // You can add custom query methods here if needed, e.g.:
//    Customers findByEmail(String email);
}
