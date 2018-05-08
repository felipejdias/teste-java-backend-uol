package br.com.felipejdias.domain;

import br.com.felipejdias.repository.JogadoresRepository;

/**
 * Classe utilizada @{link JogadoresRepository} para mapear os resultados da query utilizada para verifica codinomes disponíveis. 
 * 
 *  
 * @author Felipe Jaconis
 * 
 * @see 
 * 
 * {@link org.springframework.data.jpa.repository.Query}
 * 
 */
public class CodinomesDisponiveis {
	
	private long cdCodinome;
	private String nmCodinome;
	private TipoArquivo cdGrupo;
	
	
	/**
	 * Construtur padrão utilizado para mapear o resultado da query configurada em {@link JogadoresRepository#verificaCodinomeDisponivel}
	 * 
	 */
	public CodinomesDisponiveis(long cdCodinome, String nmCodinome, TipoArquivo tipoArquivo) {
		this.cdCodinome = cdCodinome;
		this.nmCodinome = nmCodinome;
		this.cdGrupo = tipoArquivo;
	}
	
	public long getCdCodinome() {
		return cdCodinome;
	}
	public void setCdCodinome(long cdCodinome) {
		this.cdCodinome = cdCodinome;
	}
	public String getNmCodinome() {
		return nmCodinome;
	}
	public void setNmCodinome(String nmCodinome) {
		this.nmCodinome = nmCodinome;
	}
	public TipoArquivo getCdGrupo() {
		return cdGrupo;
	}
	public void setCdGrupo(TipoArquivo cdGrupo) {
		this.cdGrupo = cdGrupo;
	}

}
