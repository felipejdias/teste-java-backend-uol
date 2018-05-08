package br.com.felipejdias.domain;

import org.springframework.util.StringUtils;

public enum TipoArquivo {
	
	VINGADORES(1L, "Os Vingadores"),
	LIGA_DA_JUSTIÇA(2l, "Liga da Justiça");
	
	private long codigo;
	private String valor;
	
	
	TipoArquivo(long codigo, String valor){
		this.codigo = codigo;
		this.valor = valor;
	}

	public static TipoArquivo fromValue(String value) {
		if (!StringUtils.isEmpty(value)) {
			for (TipoArquivo el : TipoArquivo.values()) {
				if (el.valor.equals(value)) {
					return el;
				}
			}
		}
		
		throw new IllegalArgumentException("Arquivo inválido: " + value);
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
