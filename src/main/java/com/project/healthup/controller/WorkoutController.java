package com.project.healthup.controller;

import com.project.healthup.dto.PageResponse;
import com.project.healthup.dto.WorkoutDTO;
import com.project.healthup.dto.WorkoutPostDTO;
import com.project.healthup.service.WorkoutService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PageableAsQueryParam
    public PageResponse<WorkoutDTO> getWorkouts(@PageableDefault(sort = "id") @Parameter(hidden = true) Pageable pageable,
                                                @RequestParam(required = false) String name) {
        return workoutService.getWorkouts(name, pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkoutDTO getWorkoutDetails(@PathVariable Long id) {
        return workoutService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveWorkout(@RequestBody @Valid WorkoutPostDTO dto) {
        workoutService.save(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateWorkout(@RequestBody @Valid WorkoutPostDTO dto, @PathVariable Long id) {
        workoutService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteById(id);
    }



}
