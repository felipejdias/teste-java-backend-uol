package br.com.felipejdias.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.domain.TipoArquivo;
import br.com.felipejdias.reader.ArquivoCodinome;
import br.com.felipejdias.service.CodinomeService;
import br.com.felipejdias.stubs.Codinome;

/**
 * 
 * Classe de configuração responsável por fazer consumir as URLs contendo os arquivos remotos (XML e JSON) e persistir 
 * no banco de dados. Esta configuração será executada de forma automática durante a inicialização do Spring Boot.
 * 
 * @author Felipe Jaconis
 * 
 * @see PostConstruct
 * @see Component
 * 
 * 
 */
@Component
public class ApplicationConfig {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	private List<CodinomesEntity> codinomes = new ArrayList<CodinomesEntity>();
  
	private CodinomesEntity codinome;
	
	@Autowired
	private ArquivoCodinome arquivoService;

	@Autowired
	private CodinomeService CodinomeService;
    
	/**
	 * 	Realiza a leitura dos arquivos remotos por meio 
	 *  URLs e persiste no banco de dados os dados em memória H2Database.
	 * 
	 *  Este Método utiliza a anotação <strong>@PostConstruct</strong> que é executado após a  construção 
	 *  do projeto pelo spring framework.
	 *  
	 */
    @PostConstruct
    public void init() throws JAXBException, IOException{			
		try {
			for (String codinome : arquivoService.getLigaJustica().getCodinomes().getCodinome()) {
				this.codinome = new CodinomesEntity();
				this.codinome.setNmCodinome(codinome);
				this.codinome.setCdGrupo(TipoArquivo.LIGA_DA_JUSTIÇA);
				codinomes.add(this.codinome);
			}
			
			for (Codinome codinome : arquivoService.getVingadores().getVingadores()) {
				this.codinome = new CodinomesEntity();
				this.codinome.setNmCodinome(codinome.getCodinome());
				this.codinome.setCdGrupo(TipoArquivo.VINGADORES);
				codinomes.add(this.codinome);
			}
			
			CodinomeService.salvarTodos(codinomes);
		} catch (JAXBException | IOException e) {
			log.error(e.getMessage(), e);
			throw (e);
		}
    }
}
