package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ClienteEmail;
import com.signer.vendas.repository.ClienteEmailRepository;

@Service
public class ClienteEmailService {

	@Autowired
	private ClienteEmailRepository repo;

	public ClienteEmail find(Integer id) {
		Optional<ClienteEmail> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
