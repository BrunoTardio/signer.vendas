package com.signer.vendas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.domain.Pedido;


import com.signer.vendas.domain.Produto;

import com.signer.vendas.domain.enums.EstadoPagamento;
import com.signer.vendas.domain.enums.EstadoPedido;

import com.signer.vendas.dto.PedidoNewDTO;

import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClientePJRepository;
import com.signer.vendas.repository.ClienteRepository;

import com.signer.vendas.repository.PedidoRepository;
import com.signer.vendas.repository.ProdutoCategoriaRepository;
import com.signer.vendas.repository.ProdutoRepository;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	@Autowired
	private ClienteRepository crepo;
	@Autowired
	private ClientePJRepository cpjrepo;
	@Autowired
	private ClientePFRepository cpfrepo;

	@Autowired
	private ProdutoCategoriaRepository  pcrepo;
	
	
	@Autowired
	private ProdutoRepository  prepo;
	


	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + Pedido.class.getName()));
	}

	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		//obj.setEstadoPedido(EstadoPedido.EM_ABERTO);
		//obj.setEstadoPagamento(EstadoPagamento.LOCAL);
		
		if (obj.getClientePF() != null) {
			cpfrepo.save(obj.getClientePF());
			crepo.save(obj.getClientePF().getCliente());
		}
		if (obj.getClientePJ() != null) {
			cpjrepo.save(obj.getClientePJ());
			crepo.save(obj.getClientePJ().getCliente());
		}
		
		pcrepo.save(obj.getProduto().getProdutoCategoria());
		prepo.save(obj.getProduto());
		
		repo.save(obj);
		
		return obj;
	}

	@Transactional
	public Pedido update(Pedido obj) {
		Pedido newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	
	public List<Pedido> findAll(){
		return repo.findAll();
	}
	
	 
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		
			PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
	}
	
	
	
	//
	
	@Transactional
	public Pedido fromDTO(PedidoNewDTO objDto) {
		
		Cliente cliente = new Cliente(objDto.getClienteId(), null, null);
		ClientePJ clientePJ = new ClientePJ();
		ClientePF clientePF = new ClientePF();

		Optional<Produto> produto;
		produto = prepo.findById(objDto.getProdutoId());

		if (objDto.getClientePFId() != null) {

			clientePF.setCliente(cliente);
			clientePF.setId(objDto.getClientePFId());

			Pedido pedido = new Pedido(null, objDto.getValor(), clientePF, null, produto.orElse(null),
					EstadoPedido.toEnum(objDto.getEstadoPedido()), EstadoPagamento.toEnum(objDto.getEstadoPagamento()),
					objDto.getInstante());

			return pedido;
		} else {

			clientePJ.setCliente(cliente);
			clientePJ.setId(objDto.getClientePFId());

			Pedido pedido = new Pedido(null, objDto.getValor(), null, clientePJ, produto.orElse(null),
					EstadoPedido.toEnum(objDto.getEstadoPedido()), EstadoPagamento.toEnum(objDto.getEstadoPagamento()),
					objDto.getInstante());

			return pedido;
		}

	}

	private void updateData(Pedido newObj, Pedido obj) {

		newObj.setEstadoPedido(obj.getEstadoPedido());
		newObj.setEstadoPagamento(obj.getEstadoPagamento());

	}
	
	

	
}
