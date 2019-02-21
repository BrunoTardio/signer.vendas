package com.signer.vendas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.service.ClientePJService;

@RestController
@RequestMapping(value="/clientepjs")
public class ClientePJResource {
	
	@Autowired
	private ClientePJService service;
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		ClientePJ obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	

}
