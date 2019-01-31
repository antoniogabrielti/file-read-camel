package com.projeto.teste.neogridfile.converter.dadosconsolidados;

import com.projeto.teste.neogridfile.dto.DadosConsolidados;
import com.projeto.teste.neogridfile.entity.DadosConsolidadosEntity;
import org.springframework.stereotype.Component;


@Component
public class DadosConsolidadosEntityToDadosConsolidadosConverterImpl implements DadosConsolidadosEntityToDadosConsolidadosConverter {

    @Override
    public DadosConsolidados convert(DadosConsolidadosEntity entity) {
        return new DadosConsolidados(entity.getCodigoProduto(),
                                    entity.getDescricao(),
                                    entity.getEstoque(),
                                    entity.getQuantidadeVendida(),
                                    entity.getValor(),
                                    entity.getValorTotalVendido(),
                                    entity.getDiasEstoqueDisponivel());
    }
}
