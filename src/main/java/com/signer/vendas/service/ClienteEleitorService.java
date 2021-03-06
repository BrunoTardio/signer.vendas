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
import com.signer.vendas.domain.Produto;
import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.dto.ClienteEleitorNewDTO;
import com.signer.vendas.dto.ProdutoDTO;
import com.signer.vendas.repository.ClienteEleitorRepository;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.security.UserSS;
import com.signer.vendas.service.exceptions.AuthorizationException;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;


@Service
public class ClienteEleitorService {

	@Autowired
	private ClienteEleitorRepository repo;
	
	@Autowired
	private ClienteRepository clienterepo;
	
	@Autowired
	private ClientePFRepository clientepfrepo;
	
	@Autowired
	private ClientePFService cpfservice;

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
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel deleção deste item, pois contém dados atrelados");

		}
	}
	
	public List<ClienteEleitor> findAll(){
		return repo.findAll();
	}
	
	 
	public Page<ClienteEleitor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso Negado");
		}

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		ClientePF clientePF = cpfservice.find(user.getId());

		return repo.findByClientePF(clientePF, pageRequest);
	}
	
	
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
