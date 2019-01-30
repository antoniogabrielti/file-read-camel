package com.projeto.teste.neogridfile.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name="produto")
@Entity
public class ProdutoEntity {

    @Id
    @Column(name="codigo")
    private int codigo;

    @Column(name="descricao")
    @NotNull
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
