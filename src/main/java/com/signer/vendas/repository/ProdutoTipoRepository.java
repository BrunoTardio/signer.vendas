package com.signer.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.ProdutoTipo;

@Repository
public interface ProdutoTipoRepository extends JpaRepository< ProdutoTipo, Integer> {

}
