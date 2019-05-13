package com.signer.vendas.resource;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.Produto;

import com.signer.vendas.dto.ClienteEleitorNewDTO;
import com.signer.vendas.dto.ClienteNewDTO;
import com.signer.vendas.dto.ProdutoNewDTO;
import com.signer.vendas.service.ClienteEleitorService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value="/clienteeleitores")
public class ClienteEleitorResource {
		
	@Autowired
	private ClienteEleitorService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException{
		ClienteEleitor obj = service.find(id);
		return ResponseEntity.ok().body(obj);	
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteEleitorNewDTO objDto) {
		ClienteEleitor obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteEleitorNewDTO objDto, @PathVariable Integer id){
		ClienteEleitor obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteEleitor>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "zona") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<ClienteEleitor> list = service.findPage(page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(list);

	}
	//
	
	
	
	

}
