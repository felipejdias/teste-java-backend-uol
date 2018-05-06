package br.com.felipejdias.stubs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Codinome {
	@SerializedName("codinome")
	@Expose
	private String codinome;

	public String getCodinome() {
	return codinome;
	}

	public void setCodinome(String codinome) {
	this.codinome = codinome;
	}

}
