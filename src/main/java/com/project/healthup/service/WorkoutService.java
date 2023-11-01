package com.project.healthup.service;

import com.project.healthup.dto.MetaData;
import com.project.healthup.dto.PageResponse;
import com.project.healthup.dto.WorkoutDTO;
import com.project.healthup.dto.WorkoutPostDTO;
import com.project.healthup.exception.BaseException;
import com.project.healthup.mapper.WorkoutMapper;
import com.project.healthup.model.Workout;
import com.project.healthup.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private static final WorkoutMapper mapper = Mappers.getMapper(WorkoutMapper.class);

    public PageResponse<WorkoutDTO> getWorkouts(Pageable pageable) {
        Page<WorkoutDTO> result = workoutRepository.findAll(pageable)
                .map(mapper::toDto);
        return PageResponse.of(
                result.getContent(),
                MetaData.of(result.getTotalElements(), result.getTotalPages(), result.hasNext())
        );
    }

    public WorkoutDTO findById(Long id) {
        return workoutRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new BaseException("Workout not found", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public void save(WorkoutPostDTO dto) {
        workoutRepository.save(mapper.toEntity(dto));
    }

    @Transactional
    public void update(Long id, WorkoutPostDTO dto) {
        Workout existingWorkout = workoutRepository.findById(id)
                .orElseThrow(() -> new BaseException("Workout not found", HttpStatus.NOT_FOUND));
        workoutRepository.save(mapper.update(existingWorkout, dto));
    }

    @Transactional
    public void deleteById(Long id) {
        workoutRepository.deleteById(id);
    }
}
