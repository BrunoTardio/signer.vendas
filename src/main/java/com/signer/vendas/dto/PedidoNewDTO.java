package com.signer.vendas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.signer.vendas.domain.Pedido;

public class PedidoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private double valor;
	private Integer estadoPedido;
	private Integer estadoPagamento;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;

	private Integer clientePFId;
	private Integer clientePJId;
	private Integer pedidoAgendaId;
	private Integer produtoId;
	
	public PedidoNewDTO(){
		
	}
	public PedidoNewDTO(Pedido obj){
		
		this.id = obj.getId();
		this.valor = obj.getValor();
		//this.estadoPedido = obj.getEstadoPedido().toEnum(obj.getEstadoPedido());
		//this.estadoPagamento = obj.getEstadoPagamento();
		
	}
	
	
	

}
