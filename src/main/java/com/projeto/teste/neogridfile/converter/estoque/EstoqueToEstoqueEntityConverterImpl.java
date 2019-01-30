package com.projeto.teste.neogridfile.converter.estoque;

import com.projeto.teste.neogridfile.dto.Estoque;
import com.projeto.teste.neogridfile.dto.Produto;
import com.projeto.teste.neogridfile.entity.EstoqueEntity;
import com.projeto.teste.neogridfile.entity.ProdutoEntity;
import org.springframework.stereotype.Component;


@Component
public class EstoqueToEstoqueEntityConverterImpl implements EstoqueToEstoqueEntityConverter {

    @Override
    public EstoqueEntity convert(Estoque estoque) {
        EstoqueEntity entity = new EstoqueEntity();
        entity.setCodigoProduto(estoque.getCodigoProduto());
        entity.setQuantidadeEstoque(estoque.getQuantidadeEstoque());
        return entity;
    }
}
