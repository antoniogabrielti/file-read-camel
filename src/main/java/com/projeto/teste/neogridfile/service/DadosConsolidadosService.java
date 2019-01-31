package com.projeto.teste.neogridfile.service;

import com.projeto.teste.neogridfile.converter.dadosconsolidados.DadosConsolidadosEntityToDadosConsolidadosConverter;
import com.projeto.teste.neogridfile.dto.DadosConsolidados;
import com.projeto.teste.neogridfile.jpa.DadosConsolidadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DadosConsolidadosService {

    private final static String CABECALHO = "descricao_produto;quantidade_em_estoque;valor_produto;quantidade_vendida;valor_total_vendido;dias_de_estoque_disponivel\n";
    private DadosConsolidadosRepository dadosConsolidadosRepository;
    private DadosConsolidadosEntityToDadosConsolidadosConverter dadosConsolidadosConverter;


    @Autowired
    public DadosConsolidadosService(DadosConsolidadosRepository dadosConsolidadosRepository,
                                    DadosConsolidadosEntityToDadosConsolidadosConverter dadosConsolidadosConverter) {
        this.dadosConsolidadosRepository = dadosConsolidadosRepository;
        this.dadosConsolidadosConverter = dadosConsolidadosConverter;
    }


    public String findResult(){
        String listaDadosConsolidados =
                dadosConsolidadosRepository.findAll()
                        .stream()
                        .map(dadosConsolidadosEntity -> dadosConsolidadosConverter.convert(dadosConsolidadosEntity))
                        .collect(Collectors.toList())
                        .stream().map(DadosConsolidados::toString).reduce("", String::concat);

        return CABECALHO + listaDadosConsolidados ;
    }

}
