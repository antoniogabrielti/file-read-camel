package com.projeto.teste.neogridfile.jpa;

import com.projeto.teste.neogridfile.entity.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaEntity,Integer> {
}
