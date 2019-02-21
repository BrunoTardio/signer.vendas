package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ClientePJ;

@Repository	
public interface ClientePJRepository extends JpaRepository<ClientePJ, Integer> {

}
