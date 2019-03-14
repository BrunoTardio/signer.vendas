package com.signer.vendas.dto;

import java.io.Serializable;

import com.signer.vendas.domain.ClienteEleitor;

public class ClienteEleitorNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String numero;
	private String secao;
	private String zona;
	private String cidade;
	private String uf;
	private Integer clientePFId;
	private Integer clienteId;
	
	
	public ClienteEleitorNewDTO() {
		
	}
	
	public ClienteEleitorNewDTO(ClienteEleitor obj) {
		id = obj.getId();
		numero = obj.getNumero();
		secao = obj.getSecao();
		zona = obj.getZona();
		cidade = obj.getCidade();
		uf = obj.getUf();
		clientePFId = (obj.getClientePF().getId() == null) ? null : obj.getClientePF().getId();
		clienteId =  (obj.getClientePF().getCliente().getId() == null) ? null : obj.getClientePF().getCliente().getId();
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getSecao() {
		return secao;
	}


	public void setSecao(String secao) {
		this.secao = secao;
	}


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getClientePFId() {
		return clientePFId;
	}
	
	public void setClientePFId(Integer clientePFId) {
		this.clientePFId =  clientePFId;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}
	
	public void setClienteId(Integer clienteId) {
		this.clienteId =  clienteId;
	}
}
