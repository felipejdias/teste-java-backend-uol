package br.com.felipejdias.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.SpringTemplateEngine;

import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.reader.ArquivoCodinome;
import br.com.felipejdias.service.CodinomeService;
import br.com.felipejdias.stubs.Codinome;

@Component
public class ApplicationConfig {
	
	private static final String NM_GRUPO_LIGA_JUSTICA = "Liga da Justiça";
	private static final String NM_GRUPO_VINGADORES  = "Os Vingadores";
	
	private List<CodinomesEntity> codinomes = new ArrayList<CodinomesEntity>();
  
	private CodinomesEntity codinome;
	
	@Autowired
	private ArquivoCodinome arquivoService;

	@Autowired
	private CodinomeService CodinomeService;
	
    @Autowired
    private SpringTemplateEngine templateEngine;
    
    @PostConstruct
    public void init(){			
		try {
			for (String codinome : arquivoService.getLigaJustica().getCodinomes().getCodinome()) {
				this.codinome = new CodinomesEntity();
				this.codinome.setNmCodinome(codinome);
				this.codinome.setNmGrupo(NM_GRUPO_LIGA_JUSTICA);
				codinomes.add(this.codinome);
			}
			
			for (Codinome codinome : arquivoService.getVingadores().getVingadores()) {
				this.codinome = new CodinomesEntity();
				this.codinome.setNmCodinome(codinome.getCodinome());
				this.codinome.setNmGrupo(NM_GRUPO_VINGADORES);
				codinomes.add(this.codinome);
			}
			
			CodinomeService.salvarTodos(codinomes);
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
