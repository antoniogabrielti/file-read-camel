package com.projeto.teste.neogridfile.converter.venda;

import com.projeto.teste.neogridfile.dto.Venda;
import com.projeto.teste.neogridfile.entity.VendaEntity;
import org.springframework.stereotype.Component;


@Component
public class VendaToVendaEntityConverterImpl implements VendaToVendaEntityConverter {

    @Override
    public VendaEntity convert(Venda venda) {
        VendaEntity entity = new VendaEntity();
        entity.setCodigoProduto(venda.getCodigoProduto());
        entity.setQuantidade(venda.getQuantidade());
        entity.setValor(venda.getValor());
        return entity;
    }
}
