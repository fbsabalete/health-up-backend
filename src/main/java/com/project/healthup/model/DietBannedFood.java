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
@Table(name = "diet_banned_food")
public class DietBannedFood {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIET_BANNED_FOOD_SEQ")
    @SequenceGenerator(name = "DIET_BANNED_FOOD_SEQ", sequenceName = "DIET_BANNED_FOOD_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

}