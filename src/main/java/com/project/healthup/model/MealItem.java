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
@Table(name = "meal_item")
public class MealItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEAL_ITEM_SEQ")
    @SequenceGenerator(name = "MEAL_ITEM_SEQ", sequenceName = "MEAL_ITEM_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "diet_menu_meal_id")
    private DietMenuMeal dietMenuMeal;

}