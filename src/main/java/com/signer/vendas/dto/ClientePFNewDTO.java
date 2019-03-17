package com.signer.vendas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.signer.vendas.domain.ClientePF;

public class ClientePFNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer id;
	private String nome;
	private String cpf;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date nascimento;
	private String cei;
	private String pis;
	
	private Integer clienteId;
	
	
	
	public ClientePFNewDTO() {
		
	}
	
	public ClientePFNewDTO(ClientePF obj) {
		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.nascimento = obj.getNascimento();
		this.cei = obj.getCei();
		this.pis = obj.getPis();
		this.clienteId = (obj.getCliente().getId() != null)	? obj.getCliente().getId():null;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCei() {
		return cei;
	}

	public void setCei(String cei) {
		this.cei = cei;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	

}
