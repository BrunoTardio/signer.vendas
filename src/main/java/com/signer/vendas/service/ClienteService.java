package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
