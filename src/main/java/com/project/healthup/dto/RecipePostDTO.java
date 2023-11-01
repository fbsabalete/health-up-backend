package com.project.healthup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.project.healthup.model.Recipe}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipePostDTO implements Serializable {
    @NotBlank
    private String imageUrl;
    @NotBlank
    private String recipeName;
    @PositiveOrZero
    private int portionSizeGrams;
    @PositiveOrZero
    private int totalCalories;
    @PositiveOrZero
    private int proteinAmountGrams;
    @PositiveOrZero
    private int fatAmountGrams;
    @PositiveOrZero
    private int carbsAmountGrams;
    @NotNull
    private List<TagDto> tags;
    @NotNull
    @Size(min = 1)
    private List<RecipeIngredientDto> ingredients;
    @NotBlank
    private String preparationInstructions;
}