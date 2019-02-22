package com.signer.vendas.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.signer.vendas.domain.ClienteEleitor;
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
	
	
}
