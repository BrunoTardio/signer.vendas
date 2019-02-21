package com.signer.vendas.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.service.ProdutoCategoriaService;


@RestController
@RequestMapping(value="/produtocategorias")
public class ProdutoCategoriaResource {
	
	
	@Autowired
	ProdutoCategoriaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		ProdutoCategoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
