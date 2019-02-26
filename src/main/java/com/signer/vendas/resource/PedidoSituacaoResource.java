package com.signer.vendas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.signer.vendas.domain.PedidoSituacao;

import com.signer.vendas.service.PedidoSituacaoService;

@RestController
@RequestMapping(value = "/pedidosituacoes")
public class PedidoSituacaoResource {

	@Autowired
	private PedidoSituacaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		PedidoSituacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
