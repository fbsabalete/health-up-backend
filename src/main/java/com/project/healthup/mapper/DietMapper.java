package com.project.healthup.mapper;

import com.project.healthup.dto.DietDTO;
import com.project.healthup.dto.DietDetailsDTO;
import com.project.healthup.dto.DietPostDTO;
import com.project.healthup.model.Diet;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface DietMapper {

    Diet toEntity(DietPostDTO dto);
    DietDetailsDTO toDetailDto(Diet entity);
    DietDTO toDto(Diet entity);
    Diet update(@MappingTarget Diet entity, DietPostDTO dto);

    @AfterMapping
    default void afterDietMapping(@MappingTarget Diet diet, DietPostDTO dto) {
        diet.getBenefits().forEach(b -> b.setDiet(diet));
        diet.getAllowedFood().forEach(b -> b.setDiet(diet));
        diet.getBannedFood().forEach(b -> b.setDiet(diet));
        diet.getMenuItems().forEach(b -> {
            b.setDiet(diet);
            b.getItems().forEach(m -> m.setDietMenuMeal(b));
        });
    }

}
