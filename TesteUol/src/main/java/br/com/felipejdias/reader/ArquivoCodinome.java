package br.com.felipejdias.reader;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import br.com.felipejdias.stubs.LigaDaJustica;
import br.com.felipejdias.stubs.Vingadores;

public interface ArquivoCodinome {
	
	public LigaDaJustica getLigaJustica() throws JAXBException, IOException ;
	
	public Vingadores getVingadores()throws IOException ;

}
