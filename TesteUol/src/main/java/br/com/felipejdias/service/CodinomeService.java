package br.com.felipejdias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.repository.CodinomesRepository;

@Service
public class CodinomeService {
	
	@Autowired
	private CodinomesRepository codinomes;
	
	public List<CodinomesEntity> buscarTodos(){
		return codinomes.findAll();
	}
	
	public void salvarTodos(List<CodinomesEntity> listaCodinomes) {
		codinomes.saveAll(listaCodinomes);
	}
	
	public Optional<CodinomesEntity> buscarPorId(long id) {
		return codinomes.findById(id);
	}
}
