package com.signer.vendas.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.signer.vendas.domain.ProdutoCategoria;

@RestController
@RequestMapping(value="/produtocategorias")
public class ProdutoCategoriaResource {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ProdutoCategoria> lista() {
		
		ProdutoCategoria pc1 = new ProdutoCategoria(1,"CD");
		ProdutoCategoria pc2 = new ProdutoCategoria(2,"PenDrive");
		
		List<ProdutoCategoria> lista = new ArrayList<>();
		
		lista.add(pc1);
		lista.add(pc2);
		
		return lista;
	}

}
