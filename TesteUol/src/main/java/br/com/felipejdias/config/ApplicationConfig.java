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
 * Classe de configuração responsável por fazer consumir as URLs contendo os arquivos remotos XML e JSON e armezenar 
 * no banco de dados durante a inicilização do projeto spring boot.
 * 
 * @author Felipe Jaconis
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
	 * Método responsável por realizar a leitura dos arquivos remotos por meio 
	 *  URLs e persisitir no banco de dados os dados em memória H2Database.
	 * 
	 *  Este Método utiliza a anotação <strong>@PostConstruct</strong> que é executado após a  construção 
	 *  do projeto spring boot pelo próprio framework.
	 * 
	 *  
	 * @throws {@link JAXBException}, {lkink IOException}
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
