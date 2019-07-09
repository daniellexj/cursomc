package com.daniel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

}
