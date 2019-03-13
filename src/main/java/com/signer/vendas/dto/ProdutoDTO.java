package com.signer.vendas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.signer.vendas.domain.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descricao;
	private Integer validade;
	private Double preco;
	
	public ProdutoDTO() {

	}

	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.validade = obj.getValidade();
		this.preco = obj.getPreco();
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

}
