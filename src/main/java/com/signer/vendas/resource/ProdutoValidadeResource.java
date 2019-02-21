package com.signer.vendas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signer.vendas.domain.ProdutoValidade;
import com.signer.vendas.service.ProdutoValidadeService;

@RestController
@RequestMapping(value = "/produtovalidades")
public class ProdutoValidadeResource {

	@Autowired
	private ProdutoValidadeService service;

	public ResponseEntity<?> find(Integer id) {
		ProdutoValidade obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
}
