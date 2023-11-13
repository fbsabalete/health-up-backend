package com.project.healthup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class DietDetailsDTO implements Serializable {
    private Long id;
    private String imageUrl;
    private String dietName;
    private String description;
    private List<DietBenefitDto> benefits;
    private List<DietAllowedFoodDto> allowedFood;
    private List<DietBannedFoodDto> bannedFood;
    private List<DietMenuMealDto> menuItems;
    private List<TagDto> tags;
}