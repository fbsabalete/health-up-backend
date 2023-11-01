package com.project.healthup.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "diet_menu_meal")
public class DietMenuMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIET_MENU_MEAL_SEQ")
    @SequenceGenerator(name = "DIET_MENU_MEAL_SEQ", sequenceName = "DIET_MENU_MEAL_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String mealName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dietMenuMeal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealItem> items;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

}