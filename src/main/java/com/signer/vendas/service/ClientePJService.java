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
import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.dto.ClienteEleitorNewDTO;
import com.signer.vendas.dto.ClientePJNewDTO;
import com.signer.vendas.dto.ClienteRGNewDTO;
import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.repository.ClientePJRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.security.UserSS;
import com.signer.vendas.service.exceptions.AuthorizationException;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ClientePJService {

	@Autowired
	private ClientePJRepository repo;
	
	@Autowired
	private ClienteRepository crepo;
	
	@Autowired
	private ClienteService cservice;

	public ClientePJ find(Integer id) {

		Optional<ClientePJ> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + ClientePJ.class.getName()));
	}

	@Transactional
	public ClientePJ insert(ClientePJ obj) {
		obj.setId(null);
		repo.save(obj);
		crepo.save(obj.getCliente());
		return obj;
	}

	@Transactional
	public ClientePJ update(ClientePJ obj) {
		ClientePJ newObj = find(obj.getId()); 
		
		
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
	
	
	public List<ClientePJ> findAll(){
		return repo.findAll();
	}
	
	 
	public Page<ClientePJ> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso Negado");
		}

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Cliente cliente = cservice.find(user.getId());

		return repo.findByCliente(cliente, pageRequest);
	}
	
	
	//
	
	public ClientePJ fromDTO(ClientePJNewDTO objDto) {

		Cliente cliente = new Cliente(objDto.getClienteId(), null, null);
		ClientePJ clientePJ = new ClientePJ(null, objDto.getNomeEmpresa(), objDto.getNomeEmpresa(), objDto.getCnpj(),
				objDto.getInscricaoEstadual(), objDto.getTributacao(), cliente);

		return clientePJ;

	}
	
	

	private void updateData(ClientePJ newObj, ClientePJ obj) {

		newObj.setCliente(obj.getCliente());
		newObj.setClienteEnderecos(obj.getClienteEnderecos());
		newObj.setCnpj(obj.getCnpj());
		newObj.setId(obj.getId());
		newObj.setInscricaoEstadual(obj.getInscricaoEstadual());
		newObj.setNomeEmpresa(obj.getNomeEmpresa());
		newObj.setNomeFantasia(obj.getNomeFantasia());
		newObj.setPedidos(obj.getPedidos());
		newObj.setTributacao(obj.getTributacao());

	}
	
	
}
