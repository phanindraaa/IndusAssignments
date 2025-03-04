package com.indus.training.spring.svc;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indus.training.spring.entity.Orders;

@Repository
public interface OrderDAO extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomerId(int customerId);

}
