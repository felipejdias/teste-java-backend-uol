package br.com.felipejdias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipejdias.domain.CodinomesEntity;

/**
 * Classe {@link Repository} que estende a JpaRepository que será implementada pelo spring framework.
 * 
 * O próprio framework se encarregará de criar uma implementação padrão dos métodos básicos de acesso ao dado como salvar, consulta por Id, listar todos e etc.
 *
 * 
 * @author Felipe Jaconis
 * 
 * @see JpaRepository
 * @see Repository
 * 
 * 
 */
@Repository
public interface CodinomesRepository extends JpaRepository<CodinomesEntity, Long>{

}
