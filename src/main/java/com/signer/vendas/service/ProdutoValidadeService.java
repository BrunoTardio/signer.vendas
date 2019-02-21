package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ProdutoValidade;
import com.signer.vendas.repository.ProdutoValidadeRepository;

@Service
public class ProdutoValidadeService {

	@Autowired
	private ProdutoValidadeRepository repo;

	public ProdutoValidade find(Integer id) {
		Optional<ProdutoValidade> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
