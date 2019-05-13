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
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.dto.ClientePFNewDTO;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.security.UserSS;
import com.signer.vendas.service.exceptions.AuthorizationException;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ClientePFService {

	@Autowired
	private ClientePFRepository repo;
	
	@Autowired
	private ClienteRepository crepo;
	
	@Autowired
	private ClientePFService cpfservice;

	public ClientePF find(Integer id) {
		Optional<ClientePF> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + ClientePF.class.getName()));

	}

	
	@Transactional
	public ClientePF insert(ClientePF obj) {
		obj.setId(null);
		repo.save(obj);
		crepo.save(obj.getCliente());
		return obj;
	}

	@Transactional
	public ClientePF update(ClientePF obj) {
		ClientePF newObj = find(obj.getId()); 
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
	
	
	public List<ClientePF> findAll(){
		return repo.findAll();
	}
	
	 
	public Page<ClientePF> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso Negado");
		}
		
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		ClientePF clientePF = cpfservice.find(user.getId());
		return null;
	}
	
	
	
	//
	
	public ClientePF fromDTO(ClientePFNewDTO objDto) {

		Cliente cliente = new Cliente(objDto.getClienteId(), null, null);
		ClientePF clientePF = new ClientePF(null, objDto.getNome(), objDto.getCpf(), objDto.getNascimento(),
				objDto.getCei(), objDto.getPis(), cliente);

		return clientePF;

	}
	
	private void updateData(ClientePF newObj, ClientePF obj) {

		newObj.setCei(obj.getCei());
		newObj.setCliente(obj.getCliente());
		newObj.setClienteEleitor(obj.getClienteEleitor());
		newObj.setClienteEnderecos(obj.getClienteEnderecos());
		newObj.setClienterg(obj.getClienterg());
		newObj.setCpf(obj.getCpf());
		newObj.setId(obj.getId());
		newObj.setNascimento(obj.getNascimento());
		newObj.setNome(obj.getNome());
		newObj.setPedidos(obj.getPedidos());
		newObj.setPis(obj.getPis());

	}
	
}
