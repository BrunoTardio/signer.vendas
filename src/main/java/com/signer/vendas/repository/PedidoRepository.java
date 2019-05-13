package com.signer.vendas.repository;






import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
		@Transactional(readOnly=true)
		Page<Pedido> findByClientePF(ClientePF clientePF, Pageable pageRequest);
		
		@Transactional(readOnly=true)
		Page<Pedido> findByClientePJ(ClientePJ clientePJ, Pageable pageRequest);
		
	
		
}
