package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.signer.vendas.domain.ClienteRG;
import com.signer.vendas.repository.ClienteRGRepository;

@Service
public class ClienteRGService {

	@Autowired
	private ClienteRGRepository repo;

	public ClienteRG find(Integer id) {
		Optional<ClienteRG> obj = repo.findById(id);
		return obj.orElse(null);
	}

}