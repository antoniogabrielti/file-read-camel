package com.projeto.teste.neogridfile.mapper;

import com.google.common.base.Splitter;
import com.projeto.teste.neogridfile.dto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapLineToCadastro implements MapLineToObject<Produto> {

    private Produto produto;

    @Autowired
    public MapLineToCadastro(Produto produto) {
        this.produto = produto;
    }

    @Override
    public Produto convert(String line) {

        List<String> produtosLine = Splitter.on(";").trimResults()
                .omitEmptyStrings().splitToList(line);

        produto = new Produto();
        produto.setCodigo(Integer.parseInt(produtosLine.get(0)));
        produto.setDescricao(produtosLine.get(1));
        return produto;
    }
}
