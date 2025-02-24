package com.indus.training.spring.svc;

import com.indus.training.spring.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDAO extends JpaRepository<Project, Integer> {
    // Custom query methods if needed
}
