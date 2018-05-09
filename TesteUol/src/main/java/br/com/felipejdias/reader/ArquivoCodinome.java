package br.com.felipejdias.reader;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import br.com.felipejdias.stubs.LigaDaJustica;
import br.com.felipejdias.stubs.Vingadores;

/**
 * Interface que expõe o factory para leitura de arquivos remotos.
 * 
 *  
 * @author Felipe Jaconis
 * 
 * 
 */
public interface ArquivoCodinome {
	
	/**
	 * Realiza o GET da URL e o set no objeto @{link LigaDaJustica}
	 * 
	 *  
	 * @return {@link LigaDaJustica} 
	 * 
	 */
	public LigaDaJustica getLigaJustica() throws JAXBException, IOException ;
	
	/**
	 * Realiza o GET da URL e realizar o set no objeto @{link LigaDaJustica}
	 * 
	 *  
	 * @return {@link Vingadores} 
	 * 
	 */
	public Vingadores getVingadores()throws IOException ;

}
