package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ClienteEndereco;
import com.signer.vendas.repository.ClienteEnderecoRepository;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteEnderecoService {

	@Autowired
	private ClienteEnderecoRepository repo;

	public ClienteEndereco find(Integer id) {

		Optional<ClienteEndereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + ClienteEndereco.class.getName()));
	}

}
