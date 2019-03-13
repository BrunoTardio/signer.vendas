package com.signer.vendas.dto;

import java.io.Serializable;

public class ProdutoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descricao;
	private Integer validade;
	private Double preco;
	private Integer produtoCategoriaId;
	
	public ProdutoNewDTO() {
		
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getValidade() {
		return validade;
	}

	public void setValidade(Integer validade) {
		this.validade = validade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getProdutoCategoriaId() {
		return produtoCategoriaId;
	}

	public void setProdutoCategoriaId(Integer produtoCategoriaId) {
		this.produtoCategoriaId = produtoCategoriaId;
	}


	
	
}
