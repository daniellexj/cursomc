package com.daniel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {

}
