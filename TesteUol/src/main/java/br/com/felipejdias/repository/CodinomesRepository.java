package br.com.felipejdias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipejdias.domain.CodinomesEntity;

@Repository
public interface CodinomesRepository extends JpaRepository<CodinomesEntity, Long>{

}
