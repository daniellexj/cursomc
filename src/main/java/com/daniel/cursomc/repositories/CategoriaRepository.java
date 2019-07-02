package com.daniel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

}
