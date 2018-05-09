package br.com.felipejdias;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 
 * Classe principal responsável por instanciar o objeto SpringApplication que é a classe principal do framework Spring Boot.
 * 
 *	Este projeto também utiliza JPA para persisitir no banco de dados, portanto a anotação EnableJpaAuditing é utilizada para
 *	que o framework persista informações de auditoria ao realizar alterações na base dados, como por Ex: data de alteração e inclusão.
 * 
 * @author Felipe Jaconis
 * 
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 * @see org.springframework.data.jpa.repository.config.EnableJpaAuditing
 * 
 */
@SpringBootApplication
@EnableJpaAuditing
public class SpringBootWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}