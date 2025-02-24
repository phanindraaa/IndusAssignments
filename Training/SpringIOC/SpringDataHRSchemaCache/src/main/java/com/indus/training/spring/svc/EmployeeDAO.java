package com.indus.training.spring.svc;

import com.indus.training.spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    // Custom query methods if needed
}
