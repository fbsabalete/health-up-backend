package com.project.healthup.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BularioDetailsResponse {

    @JsonProperty("numeroRegistro")
    private String numeroregistro;
    @JsonProperty("classesTerapeuticas")
    private List<String> classesterapeuticas;
    @JsonProperty("nomeComercial")
    private String nomecomercial;
    @JsonProperty("dataProduto")
    private String dataproduto;
    @JsonProperty("tipoProduto")
    private int tipoproduto;
    @JsonProperty("codigoProduto")
    private int codigoproduto;
}
