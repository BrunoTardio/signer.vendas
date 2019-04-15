package com.signer.vendas.dto;

import java.io.Serializable;

import com.signer.vendas.domain.Pedido;

public class PedidoEstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer estadoPedido;
	private Integer estadoPagamento;

	public PedidoEstadoDTO() {

	}

	public PedidoEstadoDTO(Pedido obj) {

		this.estadoPedido = obj.getEstadoPedido().getCod();
		this.estadoPagamento = obj.getEstadoPagamento().getCod();

	}

	public Integer getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(Integer estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public Integer getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

}
