package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ClientePFService {

	@Autowired
	private ClientePFRepository repo;

	public ClientePF find(Integer id) {
		Optional<ClientePF> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + ClientePF.class.getName()));

	}

}
