package com.projeto.teste.neogridfile.mapper;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.projeto.teste.neogridfile.dto.Estoque;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MapLineToEstoque implements MapLineToObject <Estoque> {

    private Estoque estoque;

    @Autowired
    public MapLineToEstoque(Estoque estoque) {
        this.estoque = estoque;
    }


    @Override
    public Function<String, Estoque> getFunction() {
        Function<String, Estoque> map = createFunction();
        return map;
    }

    private Function<String, Estoque> createFunction() {
        return new Function<String, Estoque>() {

            public Estoque apply(String line) {

                List<String> produtos = Splitter.on(";").trimResults()
                        .omitEmptyStrings().splitToList(line);

                estoque.setCodigoProduto(Integer.parseInt(produtos.get(0)));
                estoque.setQuantidadeEstoque(Integer.parseInt(produtos.get(1)));

                return estoque;
            }
        };
    }
}
