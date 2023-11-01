package com.project.healthup.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "workout")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String imageUrl;
    private String workoutName;
    private String videoUrl;
    private Boolean upperBodyBenefit;
    private Boolean lowerBodyBenefit;
    private int calories;
    private int repetitions;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutMuscle> muscles = new ArrayList<>();

    public void addMuscle(WorkoutMuscle muscle) {
        if(this.muscles == null) {
            this.muscles = new ArrayList<>();
        }
        muscle.setWorkout(this);
        this.muscles.add(muscle);
    }

    public void addMuscle(String muscle) {
        WorkoutMuscle workoutMuscle = new WorkoutMuscle();
        workoutMuscle.setName(muscle);
        addMuscle(workoutMuscle);
    }
}