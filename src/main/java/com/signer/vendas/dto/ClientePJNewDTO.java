package com.signer.vendas.dto;

import java.io.Serializable;

import com.signer.vendas.domain.ClientePJ;

public class ClientePJNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nomeEmpresa;
	private String nomeFantasia;
	private String cnpj;
	private String inscricaoEstadual;
	private String tributacao;
	
	private Integer clienteId;
	
	
	public ClientePJNewDTO(){
		
	}
	
	public ClientePJNewDTO(ClientePJ obj) {

		this.id = obj.getId();
		this.nomeEmpresa = obj.getNomeEmpresa();
		this.nomeFantasia = obj.getNomeFantasia();
		this.cnpj = obj.getCnpj();
		this.inscricaoEstadual = obj.getInscricaoEstadual();
		this.tributacao = obj.getTributacao();
		this.clienteId = (obj.getCliente().getId() != null) ? obj.getCliente().getId() : null;

	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeEmpresa() {
		return nomeEmpresa;
	}


	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}


	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}


	public String getTributacao() {
		return tributacao;
	}


	public void setTributacao(String tributacao) {
		this.tributacao = tributacao;
	}


	public Integer getClienteId() {
		return clienteId;
	}


	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
	

}
