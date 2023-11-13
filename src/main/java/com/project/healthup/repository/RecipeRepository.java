package com.project.healthup.repository;

import com.project.healthup.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Page<Recipe> findByTags_Id(Long id, Pageable pageable);
    Page<Recipe> findByRecipeNameContainsIgnoreCase(String recipeName, Pageable pageable);
}