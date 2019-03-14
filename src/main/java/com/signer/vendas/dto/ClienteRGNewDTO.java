package com.signer.vendas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.signer.vendas.domain.ClienteRG;

public class ClienteRGNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer id;
	private String nomeTitular;
	private String numeroRG;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataExpedicao;
	private String orgaoExpeditor;
	private String nomeDoPai;
	private String nomeDaMae;
	
	private Integer clientePFId;
	private Integer clienteId;
	
	
	public	ClienteRGNewDTO(){
				
	}
	
	public 	ClienteRGNewDTO(ClienteRG obj) {

		id = obj.getId();
		nomeTitular = obj.getNomeTitular();
		numeroRG = obj.getNumeroRG();
		dataExpedicao = obj.getDataExpedicao();
		orgaoExpeditor = obj.getOrgaoExpeditor();
		nomeDoPai = obj.getNomeDoPai();
		nomeDaMae = obj.getNomeDaMae();

		clientePFId = (obj.getClientepf().getId() == null) ? null : obj.getClientepf().getId();
		clienteId = (obj.getClientepf().getCliente().getId() == null) ? null : obj.getClientepf().getCliente().getId();

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

	public Integer getClientePFId() {
		return clientePFId;
	}

	public void setClientePFId(Integer clientePFId) {
		this.clientePFId = clientePFId;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	

}
