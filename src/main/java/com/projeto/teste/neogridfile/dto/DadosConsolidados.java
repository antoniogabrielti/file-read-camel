package com.projeto.teste.neogridfile.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DadosConsolidados {

    private int codigoProduto;

    private String descricao;

    private int estoque;

    private int quantidadeVendida;

    private BigDecimal valor;

    private BigDecimal valorTotalVendido;

    private String diasEstoqueDisponivel;


    public DadosConsolidados() {
    }

    public DadosConsolidados(int codigoProduto,
                             String descricao,
                             int estoque,
                             int quantidadeVendida,
                             BigDecimal valor,
                             BigDecimal valorTotalVendido,
                             String diasEstoqueDisponivel) {
        this.codigoProduto = codigoProduto;
        this.descricao = descricao;
        this.estoque = estoque;
        this.quantidadeVendida = quantidadeVendida;
        this.valor = valor;
        this.valorTotalVendido = valorTotalVendido;
        this.diasEstoqueDisponivel = diasEstoqueDisponivel;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorTotalVendido() {
        return valorTotalVendido;
    }

    public void setValorTotalVendido(BigDecimal valorTotalVendido) {
        this.valorTotalVendido = valorTotalVendido;
    }

    public String getDiasEstoqueDisponivel() {
        return diasEstoqueDisponivel;
    }

    public void setDiasEstoqueDisponivel(String diasEstoqueDisponivel) {
        this.diasEstoqueDisponivel = diasEstoqueDisponivel;
    }

    @Override
    public String toString() {
        return descricao +
                ";" + estoque +
                ";" + valor +
                ";" + quantidadeVendida +
                ";" + valorTotalVendido +
                ";" + diasEstoqueDisponivel +
                '\n';
    }
}
