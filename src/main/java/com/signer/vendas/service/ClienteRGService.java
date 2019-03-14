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
import com.signer.vendas.domain.ClienteRG;
import com.signer.vendas.dto.ClienteRGNewDTO;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClienteRGRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteRGService {
	
	@Autowired
	ClienteRGRepository repo;
	
	@Autowired
	ClientePFRepository cpfrepo;
	
	@Autowired
	ClienteRepository crepo;
	
	public ClienteRG find(Integer id) {
		Optional<ClienteRG> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + ClienteRG.class.getName()));
	}

	@Transactional
	public ClienteRG insert(ClienteRG obj) {
		obj.setId(null);
		repo.save(obj);
		cpfrepo.save(obj.getClientepf());
		crepo.save(obj.getClientepf().getCliente());
		return obj;
	}
	
	@Transactional
	public ClienteRG update(ClienteRG obj) {
		ClienteRG newObj = find(obj.getId()); 
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
	
	public List<ClienteRG> findAll(){
		return repo.findAll();
	}
	
	 
	public Page<ClienteRG> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		
			PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	

	
	//
	
	
	public ClienteRG fromDTO(ClienteRGNewDTO objDto) {

		Cliente cliente = new Cliente(objDto.getClienteId(), null, null);
		ClientePF clientePF = new ClientePF(objDto.getClientePFId(), null, null, null, null, null, cliente);
		ClienteRG clienteRG = new ClienteRG(null, objDto.getNomeTitular(), objDto.getNumeroRG(), 
				objDto.getDataExpedicao(), objDto.getOrgaoExpeditor(),objDto.getNomeDoPai(), objDto.getNomeDaMae(), clientePF);

		return clienteRG;
	}
	
	
	private void updateData(ClienteRG newObj, ClienteRG obj) {

		newObj.setClientepf(obj.getClientepf());
		newObj.setDataExpedicao(obj.getDataExpedicao());
		newObj.setId(obj.getId());
		newObj.setNomeDaMae(obj.getNomeDaMae());
		newObj.setNomeDoPai(obj.getNomeDoPai());
		newObj.setNumeroRG(obj.getNumeroRG());
		newObj.setOrgaoExpeditor(obj.getOrgaoExpeditor());

	}
	
}
