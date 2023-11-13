package com.project.healthup.controller;

import com.project.healthup.dto.PageResponse;
import com.project.healthup.dto.TagDto;
import com.project.healthup.service.TagService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PageableAsQueryParam
    public PageResponse<TagDto> findTags(@PageableDefault(sort = "id") @Parameter(hidden = true) Pageable pageable,
                                         @RequestParam(required = false) String name) {
        return service.findTags(name, pageable);
    }
}
