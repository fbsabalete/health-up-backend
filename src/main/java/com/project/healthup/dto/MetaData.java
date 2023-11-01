package com.project.healthup.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Data
public class MetaData {
    private final long totalItems;
    private final int totalPages;
    private final boolean hasNext;
}
