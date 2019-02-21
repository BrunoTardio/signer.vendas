package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ClienteEmail;

@Repository
public interface ClienteEmailRepository extends JpaRepository<ClienteEmail, Integer>{

}
