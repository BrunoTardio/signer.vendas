package com.signer.vendas.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.Produto;
import com.signer.vendas.dto.ClienteEleitorNewDTO;
import com.signer.vendas.dto.ProdutoDTO;
import com.signer.vendas.repository.ClienteEleitorRepository;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;


@Service
public class ClienteEleitorService {

	@Autowired
	private ClienteEleitorRepository repo;
	
	@Autowired
	private ClienteRepository clienterepo;
	
	@Autowired
	private ClientePFRepository clientepfrepo;

	public ClienteEleitor find(Integer id) throws ObjectNotFoundException  {
		Optional<ClienteEleitor> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! id: "+ id + ", Tipo: "+ ClienteEleitor.class.getName()));
	}
	
	@Transactional
	public ClienteEleitor insert(ClienteEleitor obj) {
		obj.setId(null);
		repo.save(obj);
		clientepfrepo.save(obj.getClientePF());
		clienterepo.save(obj.getClientePF().getCliente());
		return obj;
	}
	
	@Transactional
	public ClienteEleitor update(ClienteEleitor obj) {
		ClienteEleitor newObj = find(obj.getId()); 
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	
	
	
	

	
	//
	
	
	public ClienteEleitor fromDTO(ClienteEleitorNewDTO objDto) {

		Cliente cli = new Cliente(objDto.getClienteId(), null, null);
		ClientePF clipf = new ClientePF(objDto.getClientePFId(), null, null, null, null, null, cli);
		ClienteEleitor eleitor = new ClienteEleitor(null, objDto.getNumero(), objDto.getSecao(), objDto.getZona(),
				objDto.getCidade(), objDto.getUf(), clipf);

		return eleitor;
	}
	
	
	private void updateData(ClienteEleitor newObj, ClienteEleitor obj) {

		newObj.setCidade(obj.getCidade());
		newObj.setClientePF(obj.getClientePF());
		newObj.setNumero(obj.getNumero());
		newObj.setSecao(obj.getSecao());
		newObj.setUf(obj.getUf());
		newObj.setZona(obj.getZona());

	}
}
