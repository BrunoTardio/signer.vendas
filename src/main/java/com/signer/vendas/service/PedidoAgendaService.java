package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.PedidoAgenda;
import com.signer.vendas.repository.PedidoAgendaRepository;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoAgendaService {

	@Autowired
	private PedidoAgendaRepository repo;

	public PedidoAgenda find(Integer id) {

		Optional<PedidoAgenda> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + PedidoAgenda.class.getName()));
	}

}
