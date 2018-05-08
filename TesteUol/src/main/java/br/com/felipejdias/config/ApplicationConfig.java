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

@Component
public class ApplicationConfig {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	private List<CodinomesEntity> codinomes = new ArrayList<CodinomesEntity>();
  
	private CodinomesEntity codinome;
	
	@Autowired
	private ArquivoCodinome arquivoService;

	@Autowired
	private CodinomeService CodinomeService;
    
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
