package com.project.healthup.service;

import com.project.healthup.dto.MetaData;
import com.project.healthup.dto.PageResponse;
import com.project.healthup.dto.RecipeDTO;
import com.project.healthup.dto.RecipeDetailsDTO;
import com.project.healthup.dto.RecipePostDTO;
import com.project.healthup.exception.BaseException;
import com.project.healthup.mapper.RecipeMapper;
import com.project.healthup.model.Recipe;
import com.project.healthup.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private static final RecipeMapper mapper = Mappers.getMapper(RecipeMapper.class);

    public PageResponse<RecipeDTO> getRecipes(String name, Pageable pageable) {
        Page<RecipeDTO> result;
        if(StringUtils.isNotBlank(name)) {
            result = recipeRepository.findByRecipeNameContainsIgnoreCase(name, pageable)
                    .map(mapper::toDto);
        } else {
            result = recipeRepository.findAll(pageable)
                    .map(mapper::toDto);
        }
        return PageResponse.of(
                result.getContent(),
                MetaData.of(result.getTotalElements(), result.getTotalPages(), result.hasNext())
        );
    }

    public PageResponse<RecipeDTO> findByTag(Long tagId, Pageable pageable) {
        Page<RecipeDTO> result = recipeRepository.findByTags_Id(tagId, pageable)
                .map(mapper::toDto);
        return PageResponse.of(
                result.getContent(),
                MetaData.of(result.getTotalElements(), result.getTotalPages(), result.hasNext())
        );
    }

    public RecipeDetailsDTO findById(Long id) {
        return recipeRepository.findById(id)
                .map(mapper::toDetailDto)
                .orElseThrow(() -> new BaseException("Recipe not found", HttpStatus.NOT_FOUND));

    }

    @Transactional
    public void save(RecipePostDTO dto) {
        recipeRepository.save(mapper.toEntity(dto));
    }

    @Transactional
    public void update(Long id, RecipePostDTO dto) {
        Recipe existingRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new BaseException("Recipe not found", HttpStatus.NOT_FOUND));
        recipeRepository.save(mapper.update(dto, existingRecipe));
    }

    @Transactional
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
