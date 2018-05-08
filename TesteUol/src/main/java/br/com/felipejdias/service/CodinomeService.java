package br.com.felipejdias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.repository.CodinomesRepository;

/**
 * 
 * Classe Serviço que expõe os métodos configurados no objeto {@link CodinomesRepository} que acessam o dado da entidade {@link CodinomesEntity}
 * criados automaticamente pelo spring framework
 * 
 * @author Felipe Jaconis
 * 
 */
@Service
public class CodinomeService {
	
	@Autowired
	private CodinomesRepository codinomes;
	
	/**
	 * Busca todos os jogadores cadastrados na base de dados.
	 * 
	 * @return  List<{@link CodinomesEntity}>
	 */
	public List<CodinomesEntity> buscarTodos(){
		return codinomes.findAll();
	}
	
	/**
	 * Salva uma lista de @{link CodinomesEntity} no banco de dados.
	 * 
	 * @param @{link CodinomesEntity} lista de codinomes a serem salvas
	 */	
	public void salvarTodos(List<CodinomesEntity> listaCodinomes) {
		codinomes.saveAll(listaCodinomes);
	}
	
	/**
	 * Busca um jogador por ID.
	 * 
	 * @param Codigo do codinome a ser pesquisado
	 * @return  CodinomesEntity jogador encontrado
	 */	
	public CodinomesEntity buscarPorId(long id) {
		Optional<CodinomesEntity> op = codinomes.findById(id);
		return op.get();
	}
}
