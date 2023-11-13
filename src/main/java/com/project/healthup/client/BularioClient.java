package com.project.healthup.client;


import com.project.healthup.dto.BularioDetailsResponse;
import com.project.healthup.dto.BularioPesquisaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "bularioClient", url = "${rest.apis.bulario.base-url}")
public interface BularioClient {

    @GetMapping("/pesquisar")
    BularioPesquisaResponse pesquisa(@RequestParam("nome") String nome, @RequestParam("pagina") int pagina);

    @GetMapping("/medicamento/{numProcesso}")
    BularioDetailsResponse getDetails(@PathVariable("numProcesso") String numProcesso);

    @GetMapping("/pdf")
    ByteArrayResource getBula(@RequestParam String id);
}
