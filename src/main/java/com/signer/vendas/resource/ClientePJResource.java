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

import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.domain.Produto;
import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.dto.ClientePJNewDTO;
import com.signer.vendas.dto.ProdutoDTO;
import com.signer.vendas.service.ClientePJService;

@RestController
@RequestMapping(value="/clientepjs")
public class ClientePJResource {
	
	@Autowired
	private ClientePJService service;
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		ClientePJ obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClientePJNewDTO objDto) {
		ClientePJ obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClientePJNewDTO objDto, @PathVariable Integer id){
		ClientePJ obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<ClientePJNewDTO>> findAll() {
		List<ClientePJ> list = service.findAll();
		List<ClientePJNewDTO> listDto = list.stream().map(obj -> new ClientePJNewDTO(obj)).
				collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClientePJNewDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nomeEmpresa") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<ClientePJ> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClientePJNewDTO> listDto = list.map(obj -> new ClientePJNewDTO(obj));

		return ResponseEntity.ok().body(listDto);

	}
	

}
