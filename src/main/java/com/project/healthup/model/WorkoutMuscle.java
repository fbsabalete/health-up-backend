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
@Table(name = "workout_muscle")
public class WorkoutMuscle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORKOUT_MUSCLE_SEQ")
    @SequenceGenerator(name = "WORKOUT_MUSCLE_SEQ", sequenceName = "WORKOUT_MUSCLE_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

}