package com.signer.vendas.dto;

import java.io.Serializable;

import com.signer.vendas.domain.Cliente;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;

	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



}
