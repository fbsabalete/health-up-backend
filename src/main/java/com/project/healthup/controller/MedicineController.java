package com.project.healthup.controller;

import com.project.healthup.client.BularioClient;
import com.project.healthup.dto.BularioDetailsResponse;
import com.project.healthup.dto.BularioPesquisaResponse;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services/medicines")
@RequiredArgsConstructor
@Validated
public class MedicineController {

    private final BularioClient bularioClient;

    @GetMapping
    public BularioPesquisaResponse searchMedicines(@RequestParam("nome") @Min(value = 3) String nome,
                                                   @RequestParam(value = "pagina", required = false, defaultValue = "1") int pagina) {
        return bularioClient.pesquisa(nome, pagina);
    }

    @GetMapping("/{numProcesso}")
    public BularioDetailsResponse getDetails(@PathVariable("numProcesso") String numProcesso) {
        return bularioClient.getDetails(numProcesso);
    }

    @GetMapping(value = "/bula", produces = MediaType.APPLICATION_PDF_VALUE)
    public ByteArrayResource getBula(@Parameter(description = "Parametro 'codigoBulaPaciente' da api de detalhes") @RequestHeader String bulaToken) {
        return bularioClient.getBula(bulaToken);
    }

}
