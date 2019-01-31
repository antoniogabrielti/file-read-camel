package com.projeto.teste.neogridfile.jpa;

import com.projeto.teste.neogridfile.entity.DadosConsolidadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosConsolidadosRepository extends JpaRepository<DadosConsolidadosEntity,Integer> {
}
