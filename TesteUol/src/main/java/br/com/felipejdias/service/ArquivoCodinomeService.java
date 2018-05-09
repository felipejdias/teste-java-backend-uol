package br.com.felipejdias.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.felipejdias.reader.ArquivoCodinome;
import br.com.felipejdias.stubs.LigaDaJustica;
import br.com.felipejdias.stubs.Vingadores;

/**
 * Implementação da {@link ArquivoCodinome} criada para consumir os arquivos XML e JSON e
 * mapear os atributos para os respectivos POJOS {@link Vaingadores} e @{link LigaDaJustica} .
 * 
 *  
 * @author Felipe Jaconis
 * 
 * @see Gson
 * @see JAXB
 * 
 */
@Service
public class ArquivoCodinomeService implements ArquivoCodinome {
	
	private static final String ENDERECO_ARQUIVO_XML = "arquivo.liga.justica";
	private static final String ENDERECO_ARQUIVO_JSON = "arquivo.vingadores";
	private static final String JSON_ENCODING_DEFAULT = "UTF-8";
	
	/**
	 * Instancia um novo objeto do tipo <strong>Environment</strong> seu ciclo de vida 
	 * será gerenciado pelo spring framework. 
	 * 
	 * @see Environment
	 * @see Autowired
	 * 
	 */
	@Autowired
	private Environment env;

	
	/**
	 * Consome e faz o unmarshal do arquivo XML para o POJO {@link LigaDaJustica} utilizando o framework JAXB
	 * 
	 * @see JAXB#unmarshal
	 * 
	 * 
	 */
	@Override
	public LigaDaJustica getLigaJustica() throws JAXBException, IOException {
		URL url = new URL(env.getProperty(ENDERECO_ARQUIVO_XML));
		LigaDaJustica ligaJustica = JAXB.unmarshal(url, LigaDaJustica.class);
		return ligaJustica;
	}
	
	/**
	 * Consome e faz o parse do arquivo JSON para o POJO {@link Vingadores} utilizando o framework {@link Gson }
	 * 
	 * @see Gson#fromJson
	 * 
	 * 
	 */
	@Override
	public Vingadores getVingadores() throws IOException {
		URL url = new URL(env.getProperty(ENDERECO_ARQUIVO_JSON));
		InputStream jsonFile = url.openConnection().getInputStream();
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(jsonFile, Charset.forName(JSON_ENCODING_DEFAULT)));
		String jsonText = convertJsonToText(rd);
		Gson gson = new Gson();

		Vingadores vingadores = gson.fromJson(jsonText, Vingadores.class);

		return vingadores;
	}

	/**
	 * Converte de @{link Reader} para String a para facilitar a leitura do arquivo JSON
	 * 
	 * @see Reader
	 * 
	 * 
	 */
	private String convertJsonToText(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

}
