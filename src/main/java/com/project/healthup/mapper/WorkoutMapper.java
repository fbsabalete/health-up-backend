package com.project.healthup.mapper;

import com.project.healthup.dto.WorkoutDTO;
import com.project.healthup.dto.WorkoutPostDTO;
import com.project.healthup.model.Workout;
import com.project.healthup.model.WorkoutMuscle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface WorkoutMapper {

    WorkoutDTO toDto(Workout workout);
    @Mapping(target = "muscles", expression = "java(mapMusclesFromString(workout, dto.getMuscles()))")
    Workout toEntity(WorkoutPostDTO dto);
    @Mapping(target = "muscles", expression = "java(mapMusclesFromString(workout, dto.getMuscles()))")
    Workout update(@MappingTarget Workout workout, WorkoutPostDTO dto);

    default String toMuscleString(WorkoutMuscle muscle) {
        return muscle.getName();
    }

    default WorkoutMuscle toMuscle(String muscle, Workout workout) {
        WorkoutMuscle workoutMuscle = new WorkoutMuscle();
        workoutMuscle.setName(muscle);
        workoutMuscle.setWorkout(workout);
        return workoutMuscle;
    }

    default List<WorkoutMuscle> mapMusclesFromString(Workout workout, List<String> muscles) {
        workout.getMuscles().clear();
        muscles.forEach(workout::addMuscle);
        return workout.getMuscles();
    }
}
