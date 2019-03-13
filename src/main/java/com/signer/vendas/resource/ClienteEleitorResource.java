package com.signer.vendas.resource;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.dto.ClienteEleitorDTO;
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
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteEleitorDTO objDto) {
		ClienteEleitor obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteEleitorDTO objDto, @PathVariable Integer id){
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
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteEleitorDTO>> findAll() {
		List<ClienteEleitor> list = service.findAll();
		List<ClienteEleitorDTO> listDto = list.stream().map(obj -> new ClienteEleitorDTO(obj)).
				collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	
}
