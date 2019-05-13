package com.signer.vendas.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.ClienteRG;

@Repository
public interface ClienteRGRepository extends JpaRepository<ClienteRG, Integer>{
	
	@Transactional(readOnly=true)
	Page<ClienteRG> findByClientepf(ClientePF clientepf, Pageable pageRequest);

}
