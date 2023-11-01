package com.project.healthup.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECIPE_SEQ")
    @SequenceGenerator(name = "RECIPE_SEQ", sequenceName = "RECIPE_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String imageUrl;
    private String recipeName;

    private int portionSizeGrams;
    private int totalCalories;
    private int proteinAmountGrams;
    private int fatAmountGrams;
    private int carbsAmountGrams;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "recipe_tag",
            joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> ingredients;

    @Lob
    private String preparationInstructions;
}