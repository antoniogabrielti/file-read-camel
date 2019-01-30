package com.projeto.teste.neogridfile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.MediaType.*;


@RestController
@RequestMapping("file/dados")
public class FileControleRest {

    @GetMapping(value="/consolidados",produces = TEXT_PLAIN_VALUE)
    public String buscaDadosConsolidados() throws IOException {
        return "<teste>";
    }
}
