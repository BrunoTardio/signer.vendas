package com.signer.vendas.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.domain.ClienteEndereco;
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.dto.ClienteEnderecoNewDTO;
import com.signer.vendas.repository.ClienteEnderecoRepository;
import com.signer.vendas.service.exceptions.DataIntegrityException;
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


	public ClienteEndereco insert(ClienteEndereco obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	@Transactional
	public ClienteEndereco update(ClienteEndereco obj) {
		ClienteEndereco newObj = find(obj.getId()); 
		updateData(newObj,obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel deleção deste item, pois contém dados atrelados");

		}
	}

	public List<ClienteEndereco> findAll() {
		return repo.findAll();
	}

	public Page<ClienteEndereco> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public ClienteEndereco fromDTO(ClienteEnderecoNewDTO objDto) {

		Cliente cliente = new Cliente(objDto.getClienteId(), null, null);
		ClientePF clientePF = new ClientePF();
		ClientePJ clientePJ = new ClientePJ();

		if (objDto.getClientePFId() != null) {
			clientePF.setCliente(cliente);
			clientePF.setId(objDto.getClientePFId());
		} else {
			clientePJ.setCliente(cliente);
			clientePJ.setId(objDto.getClientePFId());
		}

		ClienteEndereco clienteEndereco = new ClienteEndereco(null, objDto.getLogradouro(), objDto.getNumero(),
				objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getUf(),
				clientePF, clientePJ);

		return clienteEndereco;

	}

//	public ClienteEndereco fromDTO(ClienteEnderecoDTO objDto) {
//	
//	return null; 
//	
//	}
//	
	private void updateData(ClienteEndereco newObj, ClienteEndereco obj) {
		
	
	}
	
	
	
}
