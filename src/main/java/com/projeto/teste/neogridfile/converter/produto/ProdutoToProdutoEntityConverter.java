package com.projeto.teste.neogridfile.converter.produto;

import com.projeto.teste.neogridfile.dto.Produto;
import com.projeto.teste.neogridfile.entity.ProdutoEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public interface ProdutoToProdutoEntityConverter extends Converter<Produto, ProdutoEntity> {
}
