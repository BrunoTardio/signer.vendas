package com.signer.vendas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.signer.vendas.domain.PedidoAgenda;

public class PedidoAgendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data;
	private Integer disponibilidade;

	public PedidoAgendaDTO() {

	}

	public PedidoAgendaDTO(PedidoAgenda obj) {

		this.id = obj.getId();
		this.data = obj.getData();
		this.disponibilidade = obj.getDisponibilidade();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Integer disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
