package com.project.healthup.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(staticName = "of")
@Data
public class PageResponse<T> {
    private final List<T> content;
    private final MetaData meta;
}
