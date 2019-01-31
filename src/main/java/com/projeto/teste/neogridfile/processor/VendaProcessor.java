package com.projeto.teste.neogridfile.processor;

import com.projeto.teste.neogridfile.converter.venda.VendaToVendaEntityConverter;
import com.projeto.teste.neogridfile.dto.Venda;
import com.projeto.teste.neogridfile.entity.VendaEntity;
import com.projeto.teste.neogridfile.jpa.VendaRepository;
import com.projeto.teste.neogridfile.mapper.MapLineToObject;
import com.projeto.teste.neogridfile.mapper.MapLineToVenda;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VendaProcessor implements Predicate {

    private static final Logger LOGGER = LoggerFactory.getLogger(VendaProcessor.class);

    private MapLineToObject<Venda> mapLineToVenda;
    private VendaRepository vendaRepository;
    private VendaToVendaEntityConverter vendaToVendaEntityConverter;

    @Autowired
    public VendaProcessor(MapLineToVenda mapLineToVenda,
                          VendaRepository vendaRepository,
                          VendaToVendaEntityConverter vendaToVendaEntityConverter) {
        this.mapLineToVenda = mapLineToVenda;
        this.vendaRepository = vendaRepository;
        this.vendaToVendaEntityConverter = vendaToVendaEntityConverter;
    }

    @Override
    public boolean matches(Exchange exchange) {
        File file =  exchange.getIn().getBody(File.class);

        String fileName = exchange.getIn().getHeader("CamelFileName").toString();

        if(idempotency(fileName)){
            try{
                List<Venda> vendas = readProdutos(file);
                vendas.forEach(this::saveVenda);
                return true;
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                return false;
            }
        }
        return true;
}


    private VendaEntity saveVenda(Venda venda) {
        return vendaRepository.saveAndFlush(Objects.requireNonNull(vendaToVendaEntityConverter.convert(venda)));
    }

    private boolean idempotency(String fileName) {
        return fileName.equals("vendas.txt");
    }

    private List<Venda> readProdutos(File file) throws IOException {
        return Files
                .lines(Paths.get(file.getAbsolutePath())).skip(1)
                .map(line -> mapLineToVenda.convert(line))
                .collect(Collectors.toList());
    }
}
