package com.projeto.teste.neogridfile.converter.dadosconsolidados;

import com.projeto.teste.neogridfile.dto.DadosConsolidados;
import com.projeto.teste.neogridfile.entity.DadosConsolidadosEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public interface DadosConsolidadosEntityToDadosConsolidadosConverter extends Converter<DadosConsolidadosEntity, DadosConsolidados> {
}
