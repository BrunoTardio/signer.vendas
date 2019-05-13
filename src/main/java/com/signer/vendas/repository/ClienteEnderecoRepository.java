package com.signer.vendas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.signer.vendas.domain.ClienteEndereco;
import com.signer.vendas.domain.ClientePF;

@Repository
public interface ClienteEnderecoRepository extends JpaRepository<ClienteEndereco, Integer>{
	
	@Transactional(readOnly=true)
	Page<ClienteEndereco> findByClientePF(ClientePF clientePF, Pageable pageRequest);

}
