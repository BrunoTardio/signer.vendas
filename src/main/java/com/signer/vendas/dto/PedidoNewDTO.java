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

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm",locale = "UTC-03")
	private Date instante;

	private Integer clienteId;
	private Integer clientePFId;
	private Integer clientePJId;
	
	private Integer produtoId;
	
	
	
	
	public PedidoNewDTO(){
		
	}

	public PedidoNewDTO(Pedido obj) {

		this.id = obj.getId();
		this.valor = obj.getProduto().getPreco();
		this.estadoPagamento = obj.getEstadoPagamento().getCod();
		this.estadoPedido = obj.getEstadoPedido().getCod();
		this.instante = obj.getInstante();
		this.clienteId = (obj.getClientePF() != null) ? obj.getClientePF().getCliente().getId()
				: obj.getClientePJ().getCliente().getId();
		this.clientePFId = (obj.getClientePF() != null) ? obj.getClientePF().getId() : null;
		this.clientePJId = (obj.getClientePJ() != null) ? obj.getClientePJ().getId() : null;
		this.produtoId = obj.getProduto().getId();
		

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getClientePFId() {
		return clientePFId;
	}

	public void setClientePFId(Integer clientePFId) {
		this.clientePFId = clientePFId;
	}

	public Integer getClientePJId() {
		return clientePJId;
	}

	public void setClientePJId(Integer clientePJId) {
		this.clientePJId = clientePJId;
	}


	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}



}
