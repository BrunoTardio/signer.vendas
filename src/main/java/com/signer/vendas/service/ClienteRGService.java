package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ClienteRG;
import com.signer.vendas.repository.ClienteRGRepository;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteRGService {
	
	@Autowired
	ClienteRGRepository repo;
	
	public ClienteRG find(Integer id) {
		Optional<ClienteRG> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + ClienteRG.class.getName()));
	}

}
