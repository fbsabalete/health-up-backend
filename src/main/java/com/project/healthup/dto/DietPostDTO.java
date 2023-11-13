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
 * DTO for {@link com.project.healthup.model.Diet}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DietPostDTO implements Serializable {
    @NotBlank
    private String imageUrl;
    @NotBlank
    private String dietName;
    @NotBlank
    private String description;
    @NotNull
    private List<DietBenefitDto> benefits;
    @NotEmpty
    private List<DietAllowedFoodDto> allowedFood;
    @NotEmpty
    private List<DietBannedFoodDto> bannedFood;
    @NotNull
    private List<DietMenuMealDto> menuItems;
    @NotNull
    private List<TagDto> tags;
}