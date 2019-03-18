package com.signer.vendas.dto;

import java.io.Serializable;

import com.signer.vendas.domain.ClienteEndereco;

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
	
	private Integer clienteId;
	
	private Integer clientePFId;
	private Integer clientePJId;
	
	
	public ClienteEnderecoNewDTO() {
		
	}

	public ClienteEnderecoNewDTO(ClienteEndereco obj) {
		this.id = obj.getId();
		this.logradouro = obj.getLogradouro();
		this.numero = obj.getNumero();
		this.complemento = obj.getComplemento();
		this.bairro = obj.getBairro();
		this.cep = obj.getCep();
		this.cidade = obj.getCidade();
		this.uf = obj.getUf();
		this.clienteId = (obj.getClientePF()!= null) ? obj.getClientePF().getCliente().getId()
				: obj.getClientePJ().getCliente().getId();
		this.clientePFId = (obj.getClientePF() != null) ? obj.getClientePF().getId() : null;
		this.clientePJId = (obj.getClientePJ() != null) ? obj.getClientePJ().getId() : null;

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

}
