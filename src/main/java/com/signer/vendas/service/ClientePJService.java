package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.repository.ClientePJRepository;

@Service
public class ClientePJService {

	@Autowired
	private ClientePJRepository repo;

	public ClientePJ find(Integer id) {

		Optional<ClientePJ> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
