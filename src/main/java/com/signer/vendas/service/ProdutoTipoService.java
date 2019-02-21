package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ProdutoTipo;
import com.signer.vendas.repository.ProdutoTipoRepository;

@Service
public class ProdutoTipoService {

	@Autowired
	private ProdutoTipoRepository repo;

	public ProdutoTipo find(Integer id) {

		Optional<ProdutoTipo> produtoTipo = repo.findById(id);
		return produtoTipo.orElse(null);
	}

}
