# Aplicação de Teste Backend da UOL

Aplicação criada para atender aos requisitos do teste para programador Java backend da UOL. Conforme descrito em https://github.com/uolhost/test-backEnd-Java

## Tecnologias Utilizadas

Java 8 (Oracle JDK)

Apache Maven 3+

spring-boot 2.0.1.RELEASE 

Com h2database, spring-boot-starter-thymeleaf, spring-boot-starter-data-jpa


## Como executar este projeto

- Com o Java 8 e Apache Maven 3 instalados rodar o comando abaixo no diretório raiz do projeto:

	mvn spring-boot:run
	
	Acessar a URL: http://localhost:8099/
	
- Ou se preferir também é possível executar a aplicação compilando e executando jar. Necessário Java 8 e Apache Maven 3 instalados e rodar os comandos abaixo no diretório raiz do projeto:

	mvn clean package
	
	java -jar target\TesteUol-1.0.0-SNAPSHOT.jar
	
## Troubleshooting

-Caso necessário é possível alterar a porta em que aplicação/banco de dados subirá. Para isto deve-se alterar a propriedade server.port no arquivo src/main/resources/application.properties para uma porta válida e que não esteja sendo usda por outro processo.


	
