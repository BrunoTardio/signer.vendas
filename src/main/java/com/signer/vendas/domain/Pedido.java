package com.signer.vendas.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	public double valor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Cliente_pf")
	private ClientePF clientePF;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Cliente_pj")
	private ClientePJ clientePJ;
	

	@ManyToOne
	@JoinColumn(name="pedido_agenda")
	private PedidoAgenda pedidoAgenda;
	

	@ManyToOne
	@JoinColumn(name="pedido_situacao")
	private PedidoSituacao pedidoSituacao;
	
    
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	
	
	public Pedido() {

	}

	public Pedido(Integer id, double valor, ClientePF clientepf, ClientePJ clientepj, PedidoAgenda pedidoAgenda, PedidoSituacao pedidoSituacao,Produto produto) {
		super();
		this.id = id;
		this.valor = valor;
		this.clientePF = clientepf;
		this.clientePJ = clientepj;
		this.pedidoAgenda = pedidoAgenda;
		this.pedidoSituacao = pedidoSituacao;
		this.produto = produto;
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

	public ClientePF getClientePF() {
		return clientePF;
	}

	public void setClientePF(ClientePF clientePF) {
		this.clientePF = clientePF;
	}

	public ClientePJ getClientePJ() {
		return clientePJ;
	}

	public void setClientePJ(ClientePJ clientePJ) {
		this.clientePJ = clientePJ;
	}

	public PedidoAgenda getPedidoAgenda() {
		return pedidoAgenda;
	}

	public void setPedidoAgenda(PedidoAgenda pedidoAgenda) {
		this.pedidoAgenda = pedidoAgenda;
	}

	

	public PedidoSituacao getPedidoSituacao() {
		return pedidoSituacao;
	}

	public void setPedidoSituacao(PedidoSituacao pedidoSituacao) {
		this.pedidoSituacao = pedidoSituacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
