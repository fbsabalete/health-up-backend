package com.project.healthup.repository;

import com.project.healthup.model.Diet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet, Long> {
    Page<Diet> findByDietNameContainsIgnoreCase(String dietName, Pageable pageable);
}