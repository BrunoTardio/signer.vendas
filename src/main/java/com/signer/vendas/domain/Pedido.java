package com.signer.vendas.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.signer.vendas.domain.enums.EstadoPagamento;
import com.signer.vendas.domain.enums.EstadoPedido;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private double valor;
	private Integer estadoPedido;
	private Integer estadoPagamento;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	
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
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	
	
	
	
	public Pedido() {

	}

	public Pedido(Integer id, double valor, ClientePF clientepf, ClientePJ clientepj, PedidoAgenda pedidoAgenda, Produto produto,EstadoPedido estadoPedido,EstadoPagamento estadoPagamento,Date instante) {
		super();
		this.id = id;
		this.valor = valor;
		this.clientePF = clientepf;
		this.clientePJ = clientepj;
		this.pedidoAgenda = pedidoAgenda;
		this.produto = produto;
		this.estadoPedido = (estadoPedido==null) ? null : estadoPedido.getCod();
		this.estadoPagamento = (estadoPagamento==null) ? null : estadoPagamento.getCod();
		this.instante = instante;
		
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


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	// armazena internamente numero inteiro controlado com os objetos do enum
	public EstadoPedido getEstadoPedido() {
		return EstadoPedido.toEnum(estadoPedido);
	}

	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido.getCod();
	}

	// armazena internamente numero inteiro controlado com os objetos do enum
	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(estadoPagamento);
	}

	public void setEstadoPedido(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCod();
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
