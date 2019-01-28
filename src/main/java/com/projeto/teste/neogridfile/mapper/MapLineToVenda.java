package com.projeto.teste.neogridfile.mapper;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.projeto.teste.neogridfile.dto.Venda;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class MapLineToVenda implements MapLineToObject<Venda> {

    private Venda venda;

    @Autowired
    public MapLineToVenda(Venda venda) {
        this.venda = venda;
    }

    public Function<String, Venda> getFunction() {

        Function<String, Venda> map = createFunction();
        return map;
    }

    private Function<String, Venda> createFunction() {
        return new Function<String, Venda>() {

            public Venda apply(String line) {

                List<String> produtos = Splitter.on(";").trimResults()
                        .omitEmptyStrings().splitToList(line);

                venda.setCodigoProduto(Integer.parseInt(produtos.get(0)));
                venda.setValor(new BigDecimal(produtos.get(1)));
                venda.setQuantidade(Integer.parseInt(produtos.get(2)));

                return venda;
            }
        };
    }
}
