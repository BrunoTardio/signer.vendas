package com.signer.vendas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.PedidoSituacao;
import com.signer.vendas.repository.PedidoSituacaoRepository;

@Service
public class PedidoSituacaoService {

	@Autowired
	private PedidoSituacaoRepository repo;

	public PedidoSituacao find(Integer id) {

		Optional<PedidoSituacao> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
