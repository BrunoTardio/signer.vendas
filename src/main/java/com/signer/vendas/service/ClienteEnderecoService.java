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
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClientePJRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteEnderecoService {

	@Autowired
	private ClienteEnderecoRepository repo;
	
	@Autowired
	private ClienteRepository crepo;
	
	@Autowired
	private ClientePJRepository cpjrepo;
	
	@Autowired
	private ClientePFRepository cpfrepo;
	
	

	public ClienteEndereco find(Integer id) {

		Optional<ClienteEndereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + ClienteEndereco.class.getName()));
	}


	@Transactional
	public ClienteEndereco insert(ClienteEndereco obj) {
		obj.setId(null);
		repo.save(obj);
		if (obj.getClientePF() != null) {
			cpfrepo.save(obj.getClientePF());
			crepo.save(obj.getClientePF().getCliente());
		}
		if (obj.getClientePJ() != null) {
			cpjrepo.save(obj.getClientePJ());
			crepo.save(obj.getClientePJ().getCliente());
		}
		return obj;
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

			ClienteEndereco clienteEndereco = new ClienteEndereco(null, objDto.getLogradouro(), objDto.getNumero(),
					objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getUf(),
					clientePF, null);
			
			
			return clienteEndereco;

		} else {
			clientePJ.setCliente(cliente);
			clientePJ.setId(objDto.getClientePJId());

			ClienteEndereco clienteEndereco = new ClienteEndereco(null, objDto.getLogradouro(), objDto.getNumero(),
					objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getUf(),
					null, clientePJ);
	
			
			return clienteEndereco;

		}

	}

//	public ClienteEndereco fromDTO(ClienteEnderecoDTO objDto) {
//	
//	return null; 
//	
//	}
//	
	private void updateData(ClienteEndereco newObj, ClienteEndereco obj) {

		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
		newObj.setCidade(obj.getCidade());
		newObj.setComplemento(obj.getComplemento());
		newObj.setId(obj.getId());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		newObj.setUf(obj.getUf());

	}

}
