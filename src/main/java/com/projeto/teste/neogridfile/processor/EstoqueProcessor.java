package com.projeto.teste.neogridfile.processor;

import com.projeto.teste.neogridfile.dto.Estoque;
import com.projeto.teste.neogridfile.mapper.MapLineToObject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class EstoqueProcessor implements Processor {

    private MapLineToObject<Estoque> mapLineToEstoque;

    @Autowired
    public EstoqueProcessor(MapLineToObject mapLineToEstoque) {
        this.mapLineToEstoque = mapLineToEstoque;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        File file =  exchange.getIn().getBody(File.class);

        String fileName = exchange.getIn().getHeader("CamelFileName").toString();

        if(idempotency(fileName)){
            List<Estoque> produtosEstoque = readProdutos(file);

            //save() - valida se o produto já foi cadastrado

        }



    }

    private boolean idempotency(String fileName) {
        return fileName.equals("estoque.txt");
    }

    private List<Estoque> readProdutos(File file) throws IOException {
        return Files
                .lines(Paths.get(file.getAbsolutePath())).skip(1)
                .map(mapLineToEstoque.getFunction()).collect(Collectors.toList());
    }
}
