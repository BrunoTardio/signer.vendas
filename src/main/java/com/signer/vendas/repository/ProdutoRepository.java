package com.signer.vendas.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.Produto;
import com.signer.vendas.domain.ProdutoCategoria;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	
	
	
	
	
	
	
	
}
