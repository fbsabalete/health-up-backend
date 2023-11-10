package com.project.healthup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BularioPesquisaResponse {

    @JsonProperty("first")
    private boolean first;
    @JsonProperty("numberOfElements")
    private int numberofelements;
    @JsonProperty("last")
    private boolean last;
    @JsonProperty("totalPages")
    private int totalpages;
    @JsonProperty("totalElements")
    private int totalelements;
    @JsonProperty("content")
    private List<BularioPesquisaContent> content;
}
