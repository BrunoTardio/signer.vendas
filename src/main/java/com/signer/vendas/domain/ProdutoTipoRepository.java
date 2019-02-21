package com.signer.vendas.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoTipoRepository extends JpaRepository<ProdutoTipo, Integer> {

}
