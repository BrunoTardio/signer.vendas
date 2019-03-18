package com.signer.vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Pedido;
import com.signer.vendas.domain.PedidoAgenda;
import com.signer.vendas.dto.PedidoAgendaDTO;
import com.signer.vendas.repository.PedidoRepository;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + Pedido.class.getName()));
	}

	
	
	
	
	
	
}
