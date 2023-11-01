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
@Table(name = "diet_benefit")
public class DietBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DIET_BENEFIT_SEQ", sequenceName = "DIET_BENEFIT_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

}