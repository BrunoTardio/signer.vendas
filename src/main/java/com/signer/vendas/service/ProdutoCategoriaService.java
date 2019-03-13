package com.signer.vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Produto;
import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.dto.ProdutoCategoriaDTO;
import com.signer.vendas.repository.ProdutoCategoriaRepository;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;


@Service
public class ProdutoCategoriaService {
	
	@Autowired
	private ProdutoCategoriaRepository repo;
	
	//tratamento de excessao
	public ProdutoCategoria find(Integer id) {
		Optional<ProdutoCategoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + ProdutoCategoria.class.getName()));

	}

	public ProdutoCategoria insert(ProdutoCategoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public ProdutoCategoria update(ProdutoCategoria obj) {
		ProdutoCategoria newObj = find(obj.getId()); 
		updateData(newObj,obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try{repo.deleteById(id);}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel deleção deste item, pois contém dados atrelados");
			
		}
	}
	
	public List<ProdutoCategoria> findAll(){
		return repo.findAll();
	}
	
	 
	public Page<ProdutoCategoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		
			PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public ProdutoCategoria fromDTO(ProdutoCategoriaDTO objDto) {
		return new ProdutoCategoria(objDto.getId(), objDto.getNome());
	}
	
private void updateData(ProdutoCategoria newObj, ProdutoCategoria obj) {
		
		newObj.setNome(obj.getNome());
	}
	
	
}
