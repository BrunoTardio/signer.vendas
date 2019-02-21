package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.PedidoAgenda;

@Repository
public interface PedidoAgendaRepository extends JpaRepository<PedidoAgenda, Integer> {

}
