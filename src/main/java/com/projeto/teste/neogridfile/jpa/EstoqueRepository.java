package com.projeto.teste.neogridfile.jpa;

import com.projeto.teste.neogridfile.entity.EstoqueEntity;
import com.projeto.teste.neogridfile.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity,Integer> {
}
