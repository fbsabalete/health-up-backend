package com.project.healthup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class WorkoutPostDTO implements Serializable {

    @NotBlank
    private String imageUrl;
    @NotBlank
    private String workoutName;
    private String videoUrl;
    @NotNull
    private Boolean upperBodyBenefit;
    @NotNull
    private Boolean lowerBodyBenefit;
    private int calories;
    private int repetitions;

    @NotEmpty
    private List<String> muscles;
}