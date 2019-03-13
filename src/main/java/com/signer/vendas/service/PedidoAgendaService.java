package com.signer.vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.PedidoAgenda;
import com.signer.vendas.dto.PedidoAgendaDTO;
import com.signer.vendas.repository.PedidoAgendaRepository;
import com.signer.vendas.service.exceptions.DataIntegrityException;
import com.signer.vendas.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoAgendaService {

	@Autowired
	private PedidoAgendaRepository repo;

	public PedidoAgenda find(Integer id) {

		Optional<PedidoAgenda> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ! ID: " + id + ", Tipo : " + PedidoAgenda.class.getName()));
	}

	public PedidoAgenda insert(PedidoAgenda obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public PedidoAgenda update(PedidoAgenda obj) {
		find(obj.getId()); // chamo no banco apenas para ver se o objeto existe
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel deleção deste item, pois contém dados atrelados");

		}
	}

	public List<PedidoAgenda> findAll() {
		return repo.findAll();
	}

	public Page<PedidoAgenda> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public PedidoAgenda fromDTO(PedidoAgendaDTO objDto) {
		return new PedidoAgenda(objDto.getId(), null,objDto.getDisponibilidade());
	}

}
