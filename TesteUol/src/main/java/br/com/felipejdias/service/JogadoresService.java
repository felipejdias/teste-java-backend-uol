package br.com.felipejdias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.domain.JogadoresEntity;
import br.com.felipejdias.repository.JogadoresRepository;

@Service
public class JogadoresService {

	@Autowired
	private JogadoresRepository jogadores;
	
	public List<JogadoresEntity> buscarTodos(){
		return jogadores.findAll();
	}
	
	public JogadoresEntity buscarPorId(long id) {
		Optional<JogadoresEntity> op = jogadores.findById(id);
		return op.get();
	}
	
	public boolean verificaCodinomeDisponivel(long codinomeJogador) {
		CodinomesEntity codinome = new CodinomesEntity();
		codinome.setCdCodinome(codinomeJogador);
		int value = jogadores.verificaCodinomeDisponivel(codinome);
		return value == 0 ? Boolean.TRUE: Boolean.FALSE;
	}
	
	public void deletar(long id) {
		jogadores.deleteById(id);
	}
	
	public void salvar(JogadoresEntity jogador) {
		jogadores.save(jogador);
	}
}
