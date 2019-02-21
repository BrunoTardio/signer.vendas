package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ClienteTelefone;

@Repository
public interface ClienteTelefoneRepository extends JpaRepository<ClienteTelefone, Integer> {

}
