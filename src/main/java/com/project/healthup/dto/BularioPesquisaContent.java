package com.project.healthup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BularioPesquisaContent {
    @JsonProperty("dataAtualizacao")
    private String dataAtualizacao;
    @JsonProperty("idBulaProfissionalProtegido")
    private String idBulaProfissionalProtegido;
    @JsonProperty("idBulaPacienteProtegido")
    private String idBulaPacienteProtegido;
    @JsonProperty("numProcesso")
    private String numProcesso;
    @JsonProperty("data")
    private String data;
    @JsonProperty("numeroTransacao")
    private String numeroTransacao;
    @JsonProperty("cnpj")
    private String cnpj;
    @JsonProperty("razaoSocial")
    private String razaoSocial;
    @JsonProperty("expediente")
    private String expediente;
    @JsonProperty("nomeProduto")
    private String nomeProduto;
    @JsonProperty("numeroRegistro")
    private String numeroRegistro;
    @JsonProperty("idProduto")
    private int idProduto;
}
