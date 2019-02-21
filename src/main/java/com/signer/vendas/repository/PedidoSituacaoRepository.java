package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.PedidoSituacao;

@Repository
public interface PedidoSituacaoRepository extends JpaRepository<PedidoSituacao, Integer> {

}
