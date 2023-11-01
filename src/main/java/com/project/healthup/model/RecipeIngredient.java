package com.project.healthup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECIPE_INGREDIENT_SEQ")
    @SequenceGenerator(name = "RECIPE_INGREDIENT_SEQ", sequenceName = "RECIPE_INGREDIENT_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String amount;
    private String ingredientName;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}