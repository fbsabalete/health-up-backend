package com.project.healthup.repository;

import com.project.healthup.model.Workout;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Page<Workout> findByWorkoutNameContainsIgnoreCase(String workoutName, Pageable pageable);
}