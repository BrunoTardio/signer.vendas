package com.signer.vendas.domain;

import java.io.Serializable;

public class ProdutoValidade implements Serializable {
	private static final long serialVersionUID = 1L;

	public Integer id;
	public Integer validade;

	public ProdutoValidade() {

	}

	public ProdutoValidade(Integer id, Integer validade) {
		super();
		this.id = id;
		this.validade = validade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValidade() {
		return validade;
	}

	public void setValidade(Integer validade) {
		this.validade = validade;
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
		ProdutoValidade other = (ProdutoValidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
