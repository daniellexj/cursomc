package com.daniel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
