package com.project.healthup.controller;

import com.project.healthup.dto.PageResponse;
import com.project.healthup.dto.RecipeDTO;
import com.project.healthup.dto.RecipeDetailsDTO;
import com.project.healthup.dto.RecipePostDTO;
import com.project.healthup.service.RecipeService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PageableAsQueryParam
    public PageResponse<RecipeDTO> getRecipes(@PageableDefault(sort = "id") @Parameter(hidden = true) Pageable pageable) {
        return service.getRecipes(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecipeDetailsDTO getRecipeDetails(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRecipe(@RequestBody @Valid RecipePostDTO dto) {
        service.save(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateRecipe(@RequestBody @Valid RecipePostDTO dto, @PathVariable Long id) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable Long id) {
        service.deleteById(id);
    }



}
