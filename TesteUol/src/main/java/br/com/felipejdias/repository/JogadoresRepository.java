package br.com.felipejdias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipejdias.domain.JogadoresEntity;

@Repository
public interface JogadoresRepository extends JpaRepository<JogadoresEntity, Long>{

}
