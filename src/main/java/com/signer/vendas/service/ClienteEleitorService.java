package com.signer.vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.dto.ClienteEleitorDTO;
import com.signer.vendas.repository.ClienteEleitorRepository;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;


@Service
public class ClienteEleitorService {

	@Autowired
	private ClienteEleitorRepository repo;

	public ClienteEleitor find(Integer id) throws ObjectNotFoundException  {
		Optional<ClienteEleitor> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! id: "+ id + ", Tipo: "+ ClienteEleitor.class.getName()));
	}

	

	public ClienteEleitor insert(ClienteEleitor obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public ClienteEleitor update(ClienteEleitor obj) {
		find(obj.getId()); // chamo no banco apenas para ver se o objeto existe
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try{repo.deleteById(id);}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel deleção deste item, pois contém dados atrelados");
			
		}
	}
	
	public List<ClienteEleitor> findAll(){
		return repo.findAll();
	}
	
	
	public ClienteEleitor fromDTO(ClienteEleitorDTO objDto) {
		return new ClienteEleitor(objDto.getId(), objDto.getNumero(), objDto.getSecao(),
				objDto.getZona(), objDto.getCidade(), objDto.getUf(), null);
	}
	
	
	
}
