package com.signer.vendas.repository;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.domain.ClientePJ;

@Repository	
public interface ClientePJRepository extends JpaRepository<ClientePJ, Integer> {
	
	@Transactional(readOnly=true)
	Page<ClientePJ> findByCliente(Cliente cliente,	Pageable pageRequest );

}
