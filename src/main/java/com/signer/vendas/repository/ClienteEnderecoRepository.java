package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ClienteEndereco;

@Repository
public interface ClienteEnderecoRepository extends JpaRepository<ClienteEndereco, Integer>{

}
