package com.signer.vendas.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.signer.vendas.domain.Cliente;
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.Produto;
import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.domain.enums.Perfil;
import com.signer.vendas.dto.ClienteDTO;
import com.signer.vendas.dto.ClienteNewDTO;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.security.UserSS;
import com.signer.vendas.service.exceptions.AuthorizationException;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repo;

	@Autowired
	ClientePFRepository cpfrepo;
	
	
	public Cliente find(Integer id) {
		

		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + Cliente.class.getName()));

	}

	@Transactional
	public Cliente insert(Cliente obj) {

		obj.setId(null);
		obj = repo.save(obj);
		cpfrepo.save(obj.getClientePF());

		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel deleção deste item, pois contém dados atrelados");

		}
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {

		return new Cliente(null, objDto.getEmail(), objDto.getSenha());
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {

		Cliente cli = new Cliente(null, objDto.getLogin(), objDto.getSenha());
		ClientePF cpf = new ClientePF(null, objDto.getNome(), objDto.getCpf(), null, null, null, cli);
		cli.setClientePF(cpf);

		if (objDto.getEmail() != null) {
			cli.getEmails().add(objDto.getEmail());
		}
		if (objDto.getTel1() != null) {
			cli.getTelefones().add(objDto.getTel1());
		}
		if (objDto.getTel2() != null) {
			cli.getTelefones().add(objDto.getTel2());
		}

		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {

		newObj.setSenha(obj.getSenha());
		newObj.setEmail(obj.getEmail());
	}

}
