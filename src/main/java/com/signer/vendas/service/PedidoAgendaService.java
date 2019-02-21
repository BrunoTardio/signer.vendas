package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.signer.vendas.domain.PedidoAgenda;
import com.signer.vendas.repository.PedidoAgendaRepository;

public class PedidoAgendaService {

	@Autowired
	private PedidoAgendaRepository repo;

	public PedidoAgenda find(Integer id) {

		Optional<PedidoAgenda> obj = repo.findById(id);

		return obj.orElse(null);
	}

}
