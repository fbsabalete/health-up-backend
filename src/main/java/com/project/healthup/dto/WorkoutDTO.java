package com.project.healthup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.project.healthup.model.Workout}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkoutDTO implements Serializable {
    private Long id;
    private String imageUrl;
    private String workoutName;
    private String videoUrl;
    private Boolean upperBodyBenefit;
    private Boolean lowerBodyBenefit;
    private int calories;
    private int repetitions;

    private List<String> muscles;
}