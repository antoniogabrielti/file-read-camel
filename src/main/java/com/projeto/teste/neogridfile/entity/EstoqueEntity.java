package com.projeto.teste.neogridfile.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name="estoque")
@Entity
public class EstoqueEntity {

    @Id
    @Column(name="codigo_produto")
    private int codigoProduto;

    @Column(name="quantidade")
    @NotNull
    private int quantidadeEstoque;

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
