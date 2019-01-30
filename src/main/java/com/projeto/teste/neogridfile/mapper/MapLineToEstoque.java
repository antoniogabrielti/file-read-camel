package com.projeto.teste.neogridfile.mapper;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.projeto.teste.neogridfile.dto.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapLineToEstoque implements MapLineToObject<Estoque> {

    private static final String QUANTIDADE_DEFAULT = "0";
    private Estoque estoque;

    @Autowired
    public MapLineToEstoque(Estoque estoque) {
        this.estoque = estoque;
    }


    @Override
    public Estoque convert(String line) {
        List<String> produtos = Splitter.on(";").trimResults()
                .omitEmptyStrings().splitToList(line);

        estoque = new Estoque();
        estoque.setCodigoProduto(Integer.parseInt(produtos.get(0)));
        estoque.setQuantidadeEstoque(Integer.parseInt(getQuantidadeEstoque(produtos.get(1))));
        return estoque;
    }

    private String getQuantidadeEstoque(String quantidade) {
        return quantidade!=null?quantidade:QUANTIDADE_DEFAULT;
    }
}
