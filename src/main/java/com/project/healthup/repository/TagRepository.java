package com.project.healthup.repository;

import com.project.healthup.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Page<Tag> findByNameStartsWithIgnoreCase(String name, Pageable pageable);
}