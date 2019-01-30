package com.projeto.teste.neogridfile.processor;

import com.projeto.teste.neogridfile.converter.produto.ProdutoToProdutoEntityConverter;
import com.projeto.teste.neogridfile.dto.Produto;
import com.projeto.teste.neogridfile.entity.ProdutoEntity;
import com.projeto.teste.neogridfile.jpa.ProdutoRepository;
import com.projeto.teste.neogridfile.mapper.MapLineToCadastro;
import com.projeto.teste.neogridfile.mapper.MapLineToObject;
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
public class CadastroProcessor implements Predicate {

    private static final Logger LOGGER = LoggerFactory.getLogger(CadastroProcessor.class);
    private MapLineToObject<Produto> mapLineToCadastro;
    private ProdutoRepository repository;
    private ProdutoToProdutoEntityConverter produtoToProdutoEntityConverter;

    @Autowired
    public CadastroProcessor(MapLineToCadastro mapLineToCadastro,
                             ProdutoRepository repository,
                             ProdutoToProdutoEntityConverter produtoToProdutoEntityConverter) {
        this.mapLineToCadastro = mapLineToCadastro;
        this.repository = repository;
        this.produtoToProdutoEntityConverter = produtoToProdutoEntityConverter;
    }

    @Override
    public boolean matches(Exchange exchange) {
        File file =  exchange.getIn().getBody(File.class);

        String fileName = exchange.getIn().getHeader("CamelFileName").toString();

        if(idempotency(fileName)){
            List<Produto> produtos = null;

            try {
                produtos = readProdutos(file);
                produtos.forEach(this::saveProduto);
                return true;
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                return false;
            }
        }
        return true;
    }

    private ProdutoEntity saveProduto(Produto produto) {
        return repository.saveAndFlush(Objects.requireNonNull(produtoToProdutoEntityConverter.convert(produto)));
    }

    private boolean idempotency(String fileName) {
        return fileName.equals("cadastro.txt");
    }

    private List<Produto> readProdutos(File file) throws IOException {
        return Files
            .lines(Paths.get(file.getAbsolutePath())).skip(1)
            .map(line -> mapLineToCadastro.convert(line)).collect(Collectors.toList());
    }
}