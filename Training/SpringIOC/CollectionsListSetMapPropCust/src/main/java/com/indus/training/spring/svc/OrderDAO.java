package com.indus.training.spring.svc;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indus.training.spring.entity.Orders;

@Repository
public interface OrderDAO extends JpaRepository<Orders, Integer> {
}
