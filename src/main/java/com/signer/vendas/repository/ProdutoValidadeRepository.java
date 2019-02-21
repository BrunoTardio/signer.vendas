package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ProdutoValidade;

@Repository 
public interface ProdutoValidadeRepository extends JpaRepository<ProdutoValidade, Integer> {

}
