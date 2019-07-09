package com.daniel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.daniel.cursomc.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

}
