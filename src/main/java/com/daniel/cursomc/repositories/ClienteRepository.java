package com.daniel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.daniel.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
