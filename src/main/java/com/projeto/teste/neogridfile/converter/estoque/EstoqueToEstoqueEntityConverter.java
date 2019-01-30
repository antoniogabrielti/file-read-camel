package com.projeto.teste.neogridfile.converter.estoque;

import com.projeto.teste.neogridfile.dto.Estoque;
import com.projeto.teste.neogridfile.dto.Produto;
import com.projeto.teste.neogridfile.entity.EstoqueEntity;
import com.projeto.teste.neogridfile.entity.ProdutoEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public interface EstoqueToEstoqueEntityConverter extends Converter<Estoque, EstoqueEntity> {
}
