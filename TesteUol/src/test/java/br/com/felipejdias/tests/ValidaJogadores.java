package br.com.felipejdias.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.domain.JogadoresEntity;
import br.com.felipejdias.service.JogadoresService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ValidaJogadores {
	

	@Autowired
	private JogadoresService jogadoresService;
	
	
	@Test(expected = DataIntegrityViolationException.class)
	public void verificaCodinomeUnicidade() {
		JogadoresEntity jogador1 = new JogadoresEntity();
		CodinomesEntity codinome = new CodinomesEntity();
		
		codinome.setCdCodinome(1l);
		codinome.setNmCodinome("Cyborg");
		codinome.setNmGrupo("Liga da Justiça");
		
		
		jogador1.setNmJogador("Felipe");
		jogador1.setDsEmail("teste@gmail.com");
		jogador1.setCdCodinome(codinome);
		
		jogadoresService.salvar(jogador1);
		
		JogadoresEntity jogador2 = new JogadoresEntity();
		
		jogador2.setNmJogador("Marcelo");
		jogador2.setDsEmail("teste@gmail.com");
		jogador2.setCdCodinome(codinome);
		
		jogadoresService.salvar(jogador2);
		
	}
	
    @TestConfiguration
    static class TestContextConfiguration {
  
        @Bean
        public JogadoresService jogadoresService() {
            return  new JogadoresService();
        }
    }
	
}
