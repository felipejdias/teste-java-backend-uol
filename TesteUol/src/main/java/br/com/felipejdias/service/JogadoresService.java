package br.com.felipejdias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipejdias.domain.CodinomesDisponiveis;
import br.com.felipejdias.domain.JogadoresEntity;
import br.com.felipejdias.domain.TipoArquivo;
import br.com.felipejdias.repository.JogadoresRepository;
import br.com.felipejdias.stubs.LigaDaJustica;
import br.com.felipejdias.stubs.Vingadores;

/**
 * 
 * Classe Serviço que expõe os métodos configurados no objeto {@link JogadoresRepository} que acessam o dado da entidade {@link JogadoresEntity} 
 * 
 * @author Felipe Jaconis
 * 
 */
@Service
public class JogadoresService {

	@Autowired
	private JogadoresRepository jogadores;
	
	/**
	 * Busca todos os jogadores cadastrados na base de dados.
	 * 
	 * @return  List<{@link JogadoresEntity}>
	 */
	public List<JogadoresEntity> buscarTodos(){
		return jogadores.findAll();
	}
	
	/**
	 * Busca um jogador por ID.
	 * 
	 * @param Codigo do jogador a ser pesquisado
	 * @return  JogadoresEntity jogador encontrado
	 */
	public JogadoresEntity buscarPorId(long id) {
		Optional<JogadoresEntity> op = jogadores.findById(id);
		return op.get();
	}
	
	/**
	 * Verifica na TB_JOGADORES quais codinomes ainda não foram selecionados.
	 * 
	 * @param @{link TipoArquivo} tipo de arquivo selecionado em tela podendo ser {@link Vingadores} ou {@link LigaDaJustica}
	 * @return  List<{@link CodinomesDisponiveis}> disponíveis para serem utilizados
	 */	
	public List<CodinomesDisponiveis> verificaCodinomeDisponivel(TipoArquivo arquivo) {
		return jogadores.verificaCodinomeDisponivel(arquivo);
	}
	
	/**
	 * Excluí um registro de  @{link JogadoresEntity} do banco de dados.
	 * 
	 * @param @{link JogadoresEntity} id do jogador a ser excluído
	 */		
	public void deletar(long id) {
		jogadores.deleteById(id);
	}
	
	/**
	 * Salva um registro de  @{link JogadoresEntity} do banco de dados.
	 * 
	 * @param @{link JogadoresEntity} id do jogador a ser salvo.
	 */		
	public void salvar(JogadoresEntity jogador) {
		jogadores.save(jogador);
	}
}
