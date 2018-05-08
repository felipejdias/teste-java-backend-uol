package br.com.felipejdias.domain;

public class CodinomesDisponiveis {
	
	private long cdCodinome;
	private String nmCodinome;
	private TipoArquivo cdGrupo;
	
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
