package br.com.felipejdias.stubs;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe gerada automaticamente que representa um POJO do arquivo JSON vingadores.json
 * 
 * 
 * @author Felipe Jaconis 
 * 
 */
public class Vingadores {

	@SerializedName("vingadores")
	@Expose
	private List<Codinome> vingadores;

	public List<Codinome> getVingadores() {
		return vingadores;
	}

	public void setVingadores(List<Codinome> vingadores) {
		this.vingadores = vingadores;
	}

}
