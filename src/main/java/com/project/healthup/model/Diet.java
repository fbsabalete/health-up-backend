package com.project.healthup.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "diet")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DIET_SEQ", sequenceName = "DIET_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String imageUrl;
    private String dietName;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietBenefit> benefits;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietAllowedFood> allowedFood;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietBannedFood> bannedFood;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietMenuMeal> menuItems;

}