package com.signer.vendas.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/produtocategorias")
public class ProdutoCategoriaResource {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String lista() {
		
		return "Lista de String";
	}

}
