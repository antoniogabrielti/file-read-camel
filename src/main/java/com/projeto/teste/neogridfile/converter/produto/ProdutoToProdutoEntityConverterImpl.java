package com.projeto.teste.neogridfile.converter.produto;

import com.projeto.teste.neogridfile.dto.Produto;
import com.projeto.teste.neogridfile.entity.ProdutoEntity;
import org.springframework.stereotype.Component;


@Component
public class ProdutoToProdutoEntityConverterImpl implements ProdutoToProdutoEntityConverter {

    @Override
    public ProdutoEntity convert(Produto produto) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setCodigo(produto.getCodigo());
        entity.setDescricao(produto.getDescricao());
        return entity;
    }
}
