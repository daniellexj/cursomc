package com.daniel.cursomc.domain;

import javax.persistence.Entity;

import com.daniel.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcela;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer numeroDeParcela) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.setNumeroDeParcela(numeroDeParcela);
	}

	public Integer getNumeroDeParcela() {
		return numeroDeParcela;
	}

	public void setNumeroDeParcela(Integer numeroDeParcela) {
		this.numeroDeParcela = numeroDeParcela;
	}

	
	

}
