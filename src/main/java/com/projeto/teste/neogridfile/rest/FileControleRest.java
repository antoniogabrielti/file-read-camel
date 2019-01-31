package com.projeto.teste.neogridfile.rest;

import com.projeto.teste.neogridfile.service.DadosConsolidadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.MediaType.*;


@RestController
@RequestMapping("file/dados")
public class FileControleRest {

    private DadosConsolidadosService dadosConsolidadosService;

    @Autowired
    public FileControleRest(DadosConsolidadosService dadosConsolidadosService) {
        this.dadosConsolidadosService = dadosConsolidadosService;
    }

    @GetMapping(value="/consolidados",produces = TEXT_PLAIN_VALUE)
    public String buscaDadosConsolidados() throws IOException {
        return dadosConsolidadosService.findResult();
    }
}
