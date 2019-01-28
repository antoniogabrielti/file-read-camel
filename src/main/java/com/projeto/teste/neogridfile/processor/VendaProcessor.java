package com.projeto.teste.neogridfile.processor;

import com.projeto.teste.neogridfile.dto.Venda;
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


public class VendaProcessor implements Processor {

    private MapLineToObject<Venda> mapLineToVenda;

    @Autowired
    public VendaProcessor(MapLineToObject mapLineToVenda) {
        this.mapLineToVenda = mapLineToVenda;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        File file =  exchange.getIn().getBody(File.class);

        String fileName = exchange.getIn().getHeader("CamelFileName").toString();

        if(idempotency(fileName)){
            List<Venda> vendas = readProdutos(file);


        }



    }

    private boolean idempotency(String fileName) {
        return fileName.equals("vendas.txt");
    }

    private List<Venda> readProdutos(File file) throws IOException {
        return Files
                .lines(Paths.get(file.getAbsolutePath())).skip(1)
                .map(mapLineToVenda.getFunction()).collect(Collectors.toList());
    }
}
