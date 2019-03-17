package com.signer.vendas.dto;

import java.io.Serializable;

public class ClienteEnderecoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	
	private Integer ClienteId;
	
	private Integer ClientePFId;
	private Integer ClientePJId;
	
	
	public ClienteEnderecoNewDTO() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
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


	public Integer getClienteId() {
		return ClienteId;
	}


	public void setClienteId(Integer clienteId) {
		ClienteId = clienteId;
	}


	public Integer getClientePFId() {
		return ClientePFId;
	}


	public void setClientePFId(Integer clientePFId) {
		ClientePFId = clientePFId;
	}


	public Integer getClientePJId() {
		return ClientePJId;
	}


	public void setClientePJId(Integer clientePJId) {
		ClientePJId = clientePJId;
	}
	
	
}
