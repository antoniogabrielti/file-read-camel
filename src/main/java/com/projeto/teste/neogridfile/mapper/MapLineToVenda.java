package com.projeto.teste.neogridfile.mapper;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.projeto.teste.neogridfile.dto.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class MapLineToVenda implements MapLineToObject<Venda> {

    private Venda venda;

    @Autowired
    public MapLineToVenda(Venda venda) {
        this.venda = venda;
    }


    @Override
    public Venda convert(String line) {
        List<String> produtos = Splitter.on(";").trimResults()
                .omitEmptyStrings().splitToList(line);

        venda = new Venda();
        venda.setCodigoProduto(Integer.parseInt(produtos.get(0)));
        venda.setValor(new BigDecimal(produtos.get(1)));
        venda.setQuantidade(Integer.parseInt(produtos.get(2)));
        return venda;
    }
}
