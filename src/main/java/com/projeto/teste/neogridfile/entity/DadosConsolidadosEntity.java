package com.projeto.teste.neogridfile.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name="dados_consolidados")
@Entity
public class DadosConsolidadosEntity {

    @Id
    @Column(name="codigo_produto")
    private int codigoProduto;

    @Column(name="descricao")
    private String descricao;

    @Column(name="estoque")
    private int estoque;

    @Column(name="quantidade_vendida")
    private int quantidadeVendida;

    @Column(name="valor")
    private BigDecimal valor;

    @Column(name="valor_total_vendido")
    private BigDecimal valorTotalVendido;

    @Column(name="dias_estoque_disponivel")
    private String diasEstoqueDisponivel;

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
}
