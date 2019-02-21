package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ClienteEleitor;

@Repository
public interface ClienteEleitorRepository extends JpaRepository<ClienteEleitor, Integer> {

}
