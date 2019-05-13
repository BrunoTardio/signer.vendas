package com.signer.vendas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.domain.ClientePF;


@Repository
public interface ClienteEleitorRepository extends JpaRepository<ClienteEleitor, Integer> {

	
	@Transactional(readOnly=true)
	Page<ClienteEleitor> findByClientePF(ClientePF clientepf, Pageable pageRequest);
	
}
