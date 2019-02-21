package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ClienteTelefone;
import com.signer.vendas.repository.ClienteTelefoneRepository;

@Service
public class ClienteTelefoneService {

	@Autowired
	private ClienteTelefoneRepository repo;

	public ClienteTelefone find(Integer id) {
		Optional<ClienteTelefone> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
