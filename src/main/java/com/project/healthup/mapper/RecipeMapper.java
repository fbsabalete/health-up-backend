package com.project.healthup.mapper;

import com.project.healthup.dto.RecipeDTO;
import com.project.healthup.dto.RecipeDetailsDTO;
import com.project.healthup.dto.RecipePostDTO;
import com.project.healthup.model.Recipe;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipeMapper {
    Recipe toEntity(RecipePostDTO recipePostDTO);

    @AfterMapping
    default void linkIngredients(@MappingTarget Recipe recipe) {
        recipe.getIngredients().forEach(ingredient -> ingredient.setRecipe(recipe));
    }

    RecipeDTO toDto(Recipe recipe);
    RecipeDetailsDTO toDetailDto(Recipe recipe);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recipe update(RecipePostDTO recipePostDTO, @MappingTarget Recipe recipe);
}