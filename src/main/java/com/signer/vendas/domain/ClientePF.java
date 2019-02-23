package com.signer.vendas.domain;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ClientePF implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String nascimento;
	private String cei;
	private String pis;
	

	@ElementCollection
	@CollectionTable(name="ClienteRGTeste")
	Set<ClienteRG> clienteRG = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name="cliente_id")
	//@MapsId
	Cliente cliente;

	@OneToOne(cascade=CascadeType.ALL,mappedBy="clientepf")
	ClienteRG clienterg;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="clientePF")
	ClienteEleitor clienteEleitor;

	public ClientePF() {

	}

	public ClientePF(Integer id, String nome, String cpf, String nascimento, String cei, String pis,Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.cei = cei;
		this.pis = pis;
		this.cliente = cliente;
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

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ClienteRG> getClienteRG() {
		return clienteRG;
	}

	public void setClienteRG(Set<ClienteRG> clienteRG) {
		this.clienteRG = clienteRG;
	}

	public ClienteRG getClienterg() {
		return clienterg;
	}

	public void setClienterg(ClienteRG clienterg) {
		this.clienterg = clienterg;
	}

	public ClienteEleitor getClienteEleitor() {
		return clienteEleitor;
	}

	public void setClienteEleitor(ClienteEleitor clienteEleitor) {
		this.clienteEleitor = clienteEleitor;
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
		ClientePF other = (ClientePF) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
