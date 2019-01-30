package com.projeto.teste.neogridfile.processor;

import com.projeto.teste.neogridfile.converter.estoque.EstoqueToEstoqueEntityConverter;
import com.projeto.teste.neogridfile.dto.Estoque;
import com.projeto.teste.neogridfile.entity.EstoqueEntity;
import com.projeto.teste.neogridfile.jpa.EstoqueRepository;
import com.projeto.teste.neogridfile.jpa.ProdutoRepository;
import com.projeto.teste.neogridfile.mapper.MapLineToEstoque;
import com.projeto.teste.neogridfile.mapper.MapLineToObject;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.Processor;
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
public class EstoqueProcessor implements Predicate {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstoqueProcessor.class);

    private MapLineToObject<Estoque> mapLineToEstoque;
    private ProdutoRepository produtoRepository;
    private EstoqueRepository estoqueRepository;
    private EstoqueToEstoqueEntityConverter estoqueToEstoqueEntityConverter;


    @Autowired
    public EstoqueProcessor(MapLineToEstoque mapLineToEstoque,
                            ProdutoRepository produtoRepository,
                            EstoqueRepository estoqueRepository,
                            EstoqueToEstoqueEntityConverter estoqueToEstoqueEntityConverter) {
        this.mapLineToEstoque = mapLineToEstoque;
        this.produtoRepository = produtoRepository;
        this.estoqueRepository = estoqueRepository;
        this.estoqueToEstoqueEntityConverter = estoqueToEstoqueEntityConverter;
    }

    @Override
    public boolean matches(Exchange exchange) {
        File file =  exchange.getIn().getBody(File.class);

        String fileName = exchange.getIn().getHeader("CamelFileName").toString();

        if(idempotency(fileName)){
            List<Estoque> produtosEstoque = null;
            try {
                produtosEstoque = readProdutos(file);
                produtosEstoque.forEach(this::saveEstoque);
                return true;
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                return false;
            }
        }
        return true;
    }


    private EstoqueEntity saveEstoque(Estoque estoque) {
        return estoqueRepository.saveAndFlush(Objects.requireNonNull(estoqueToEstoqueEntityConverter.convert(estoque)));
    }

    private boolean idempotency(String fileName) {
        return fileName.equals("estoque.txt");
    }

    private List<Estoque> readProdutos(File file) throws IOException {
        return Files
                .lines(Paths.get(file.getAbsolutePath())).skip(1)
                .map(line -> mapLineToEstoque.convert(line))
                .filter(estoque -> produtoRepository.existsById(estoque.getCodigoProduto()))
                .collect(Collectors.toList());
    }
}
