package com.signer.vendas.domain;

import java.io.Serializable;
import java.util.Date;

public class ClienteRG implements Serializable {
	private static final long serialVersionUID = 1L;

	public Integer id;
	public String nomeTitular;
	public String numeroRG;
	public Date dataExpedicao;
	public String orgaoExpeditor;
	public String nomeDoPai;
	public String nomeDaMae;

	public ClienteRG() {

	}

	public ClienteRG(Integer id, String nomeTitular, String numeroRG, Date dataExpedicao, String orgaoExpeditor,
			String nomeDoPai, String nomeDaMae) {
		super();
		this.id = id;
		this.nomeTitular = nomeTitular;
		this.numeroRG = numeroRG;
		this.dataExpedicao = dataExpedicao;
		this.orgaoExpeditor = orgaoExpeditor;
		this.nomeDoPai = nomeDoPai;
		this.nomeDaMae = nomeDaMae;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroRG() {
		return numeroRG;
	}

	public void setNumeroRG(String numeroRG) {
		this.numeroRG = numeroRG;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
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
		ClienteRG other = (ClienteRG) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
