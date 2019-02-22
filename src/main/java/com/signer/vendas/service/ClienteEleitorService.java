package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.repository.ClienteEleitorRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteEleitorService {

	@Autowired
	private ClienteEleitorRepository repo;

	public ClienteEleitor find(Integer id) throws ObjectNotFoundException  {
		Optional<ClienteEleitor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! id: "+ id + ", Tipo: "+ ClienteEleitor.class.getName()));
	}

}
