package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.repository.ProdutoCategoriaRepository;

@Service
public class ProdutoCategoriaService {
	
	@Autowired
	private ProdutoCategoriaRepository repo;
	
	
	public ProdutoCategoria find(Integer id) {

		Optional<ProdutoCategoria> obj = repo.findById(id);

		return obj.orElse(null);

	}
	

}
