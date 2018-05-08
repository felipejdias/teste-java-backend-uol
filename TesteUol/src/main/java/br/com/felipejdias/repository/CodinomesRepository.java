package br.com.felipejdias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipejdias.domain.CodinomesEntity;

/**
 * Classe {@link Repository} que estende a JpaRepository que será implementada e executada pelo spring framework expondo
 *
 * 
 * @author Felipe Jaconis
 * 
 * @see 
 * 
 * {@link JpaRepository}
 * 
 */
@Repository
public interface CodinomesRepository extends JpaRepository<CodinomesEntity, Long>{

}
