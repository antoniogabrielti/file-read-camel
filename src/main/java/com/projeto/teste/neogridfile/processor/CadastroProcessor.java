package com.projeto.teste.neogridfile.processor;

import com.projeto.teste.neogridfile.dto.Cadastro;
import com.projeto.teste.neogridfile.mapper.MapLineToObject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CadastroProcessor implements Processor {

    private MapLineToObject<Cadastro> mapLineToCadastro;

    @Autowired
    public CadastroProcessor(MapLineToObject mapLineToCadastro) {
        this.mapLineToCadastro = mapLineToCadastro;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        File file =  exchange.getIn().getBody(File.class);

        String fileName = exchange.getIn().getHeader("CamelFileName").toString();

        if(idempotency(fileName)){
            List<Cadastro> cadastros = readProdutos(file);


        }



    }

    private boolean idempotency(String fileName) {
        return fileName.equals("cadastro.txt");
    }

    private List<Cadastro> readProdutos(File file) throws IOException {
        return Files
                .lines(Paths.get(file.getAbsolutePath())).skip(1)
                .map(mapLineToCadastro.getFunction()).collect(Collectors.toList());
    }
}