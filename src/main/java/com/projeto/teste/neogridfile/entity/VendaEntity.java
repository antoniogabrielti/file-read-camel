package com.projeto.teste.neogridfile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Table(name="venda")
@Entity
public class VendaEntity {

    @Id
    @Column(name="codigo_produto")
    private int codigoProduto;

    @Column(name="valor_produto")
    @NotNull
    private BigDecimal valor;

    @Column(name="quantidade_vendida")
    @NotNull
    private int quantidade;

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
