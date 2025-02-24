package com.indus.training.spring.svc;

import com.indus.training.spring.entity.EmployeeProject;
import com.indus.training.spring.entity.EmployeeProjectId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectDAO extends JpaRepository<EmployeeProject, EmployeeProjectId> {
    // Custom query methods if needed
}
