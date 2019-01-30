package com.projeto.teste.neogridfile.jpa;

import com.projeto.teste.neogridfile.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Integer> {
}
