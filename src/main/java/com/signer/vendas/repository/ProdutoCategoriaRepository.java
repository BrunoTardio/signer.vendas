package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ProdutoCategoria;

@Repository
public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Integer>{

}
