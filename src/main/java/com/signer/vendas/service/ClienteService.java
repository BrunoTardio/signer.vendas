package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.repository.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {

	private ClienteRepository repo;

	public Cliente find(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! id: "+ id + ", Tipo: "+ Cliente.class.getName()));
	}

}
