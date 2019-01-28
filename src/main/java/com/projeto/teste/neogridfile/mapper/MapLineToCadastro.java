package com.projeto.teste.neogridfile.mapper;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.projeto.teste.neogridfile.dto.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapLineToCadastro implements MapLineToObject<Cadastro> {

    private Cadastro cadastro;

    @Autowired
    public MapLineToCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public Function<String, Cadastro> getFunction() {

        Function<String, Cadastro> map = createFunction();
        return map;
    }

    private Function<String, Cadastro> createFunction() {
        return new Function<String, Cadastro>() {

                public Cadastro apply(String line) {

                    List<String> produtos = Splitter.on(";").trimResults()
                            .omitEmptyStrings().splitToList(line);

                    cadastro.setCodigoProduto(Integer.parseInt(produtos.get(0)));
                    cadastro.setDescricaoProduto(produtos.get(1));

                    return cadastro;
                }
            };
    }

}
