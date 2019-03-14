package com.signer.vendas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ClientePF implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date nascimento;
	private String cei;
	private String pis;
	

	@ElementCollection
	@CollectionTable(name="ClienteRGTeste")
	private Set<ClienteRG> clienteRG = new HashSet<>();
	

	@OneToMany(cascade=CascadeType.ALL,mappedBy="clientePF")
	private List<ClienteEndereco> clienteEnderecos = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="cliente_id")
	//@MapsId  mapeia o ID do Cliente para ser o mesmo em ClientePF
	private Cliente cliente;

	// ok
	@OneToOne(cascade=CascadeType.REMOVE,mappedBy="clientepf")
	private ClienteRG clienterg;
	
	// ok
	@OneToOne(cascade=CascadeType.REMOVE,mappedBy="clientePF")
	private ClienteEleitor clienteEleitor;
	
	
	@OneToMany(mappedBy="clientePF")
	private List<Pedido> pedidos = new ArrayList<>();

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ClientePF() {

	}

	public ClientePF(Integer id, String nome, String cpf, Date nascimento, String cei, String pis,Cliente cliente) {
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

	public List<ClienteEndereco> getClienteEnderecos() {
		return clienteEnderecos;
	}

	public void setClienteEnderecos(List<ClienteEndereco> clienteEnderecos) {
		this.clienteEnderecos = clienteEnderecos;
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
