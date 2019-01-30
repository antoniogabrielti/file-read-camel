package com.projeto.teste.neogridfile.processor;

import com.projeto.teste.neogridfile.dto.Venda;
import com.projeto.teste.neogridfile.mapper.MapLineToObject;
import com.projeto.teste.neogridfile.mapper.MapLineToVenda;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
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
public class VendaProcessor implements Predicate {

    private MapLineToObject<Venda> mapLineToVenda;

    @Autowired
    public VendaProcessor(MapLineToVenda mapLineToVenda) {
        this.mapLineToVenda = mapLineToVenda;
    }

    @Override
    public boolean matches(Exchange exchange) {
        File file =  exchange.getIn().getBody(File.class);

        String fileName = exchange.getIn().getHeader("CamelFileName").toString();

        if(idempotency(fileName)){
//            List<Venda> vendas = readProdutos(file);


        }

        return true;

    }

    private boolean idempotency(String fileName) {
        return fileName.equals("vendas.txt");
    }

    private List<Venda> readProdutos(File file) throws IOException {
        return Files
                .lines(Paths.get(file.getAbsolutePath())).skip(1)
                .map(line -> mapLineToVenda.convert(line)).collect(Collectors.toList());
    }
}
