package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ClienteRG;

@Repository
public interface ClienteRGRepository extends JpaRepository<ClienteRG, Integer>{

}
