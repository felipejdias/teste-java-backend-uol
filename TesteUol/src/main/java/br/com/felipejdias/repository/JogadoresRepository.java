package br.com.felipejdias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.domain.JogadoresEntity;

@Repository
public interface JogadoresRepository extends JpaRepository<JogadoresEntity, Long>{
	
	@Query("SELECT COUNT(*) FROM JogadoresEntity j WHERE j.cdCodinome = :cdCodinome")
	public int verificaCodinomeDisponivel(@Param(value = "cdCodinome") CodinomesEntity cdCodinome);

}
