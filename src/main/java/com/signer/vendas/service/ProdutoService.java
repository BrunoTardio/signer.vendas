package com.signer.vendas.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Produto;
import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.domain.Produto;
import com.signer.vendas.dto.ProdutoDTO;
import com.signer.vendas.dto.ProdutoNewDTO;
import com.signer.vendas.dto.ProdutoDTO;
import com.signer.vendas.repository.ProdutoCategoriaRepository;
import com.signer.vendas.repository.ProdutoRepository;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private ProdutoCategoriaRepository pcrepo;

	public Produto find(Integer id) {

		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + Produto.class.getName()));
	}

	
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	@Transactional
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId()); 
		updateData(newObj,obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel deleção deste item, pois contém dados atrelados");

		}
	}

	public List<Produto> findAll() {
		return repo.findAll();
	}

	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Produto fromDTO(ProdutoDTO objDto) {
		
		return new Produto(objDto.getId(),objDto.getNome(),objDto.getDescricao(),null,objDto.getValidade(),objDto.getPreco());
	}

	public Produto fromDTO(ProdutoNewDTO objDto) {
	
	 ProdutoCategoria pc = new ProdutoCategoria(objDto.getProdutoCategoriaId(), null);
	 Produto pro = new Produto(null,objDto.getNome(),objDto.getDescricao(),pc,objDto.getValidade(),objDto.getPreco());
			 return pro;
	}
	
	private void updateData(Produto newObj, Produto obj) {
		
		newObj.setDescricao(obj.getDescricao());
		newObj.setNome(obj.getNome());
		newObj.setPreco(obj.getPreco());
		newObj.setValidade(obj.getValidade());
	}
	
}
