package com.project.healthup.controller;

import com.project.healthup.dto.DietDTO;
import com.project.healthup.dto.DietDetailsDTO;
import com.project.healthup.dto.DietPostDTO;
import com.project.healthup.dto.PageResponse;
import com.project.healthup.service.DietService;
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
@RequestMapping("/api/services/diets")
@RequiredArgsConstructor
public class DietController {

    private final DietService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PageableAsQueryParam
    public PageResponse<DietDTO> getDiets(@PageableDefault(sort = "id") @Parameter(hidden = true) Pageable pageable) {
        return service.getDiets(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DietDetailsDTO getDietDetails(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDiet(@RequestBody @Valid DietPostDTO dto) {
        service.save(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDiet(@RequestBody @Valid DietPostDTO dto, @PathVariable Long id) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDiet(@PathVariable Long id) {
        service.deleteById(id);
    }



}
