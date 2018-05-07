package br.com.felipejdias.tests;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.felipejdias.reader.ArquivoCodinome;
import br.com.felipejdias.service.ArquivoCodinomeService;


@TestPropertySource(locations="classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidaArquivoCodinomes {
	
	private static final String ENDERECO_ARQUIVO_XML = "arquivo.liga.justica";
	private static final String ENDERECO_ARQUIVO_JSON = "arquivo.vingadores";
	private static final String ARQUIVO_XML_CONTENT_TYPE = "text/plain; charset=utf-8";
	private static final String ARQUIVO_JSON_CONTENT_TYPE = "text/plain; charset=utf-8";
	
    @Autowired
    private ArquivoCodinome arquivoService;
    
	@Autowired
	private Environment env;
    
    
    @Test
    public void verificaArquivoLiga() throws JAXBException, IOException {
    	assertThat(arquivoService.getLigaJustica() != null);
    }
    
    @Test
    public void verificaArquivoVingadores() throws IOException {
    	assertThat(arquivoService.getVingadores() != null);
    }
    
    @Test
    public void verificaArquivoXml() throws IOException {
    	URL url = new URL(env.getProperty(ENDERECO_ARQUIVO_XML));
    	assertThat(url.openConnection().getContentType().equals(ARQUIVO_XML_CONTENT_TYPE));
    }
    
    @Test
    public void verificaArquivoJson() throws IOException {
    	URL url = new URL(env.getProperty(ENDERECO_ARQUIVO_JSON));
    	assertThat(url.openConnection().getContentType().equals(ARQUIVO_JSON_CONTENT_TYPE));
    }
    
    @TestConfiguration
    static class TestContextConfiguration {
  
        @Bean
        public ArquivoCodinomeService arquivoService() {
            return  new ArquivoCodinomeService();
        }
    }
    
    

}
