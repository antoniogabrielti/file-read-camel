package com.projeto.teste.neogridfile.converter.venda;

import com.projeto.teste.neogridfile.dto.Venda;
import com.projeto.teste.neogridfile.entity.VendaEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public interface VendaToVendaEntityConverter extends Converter<Venda, VendaEntity> {
}
