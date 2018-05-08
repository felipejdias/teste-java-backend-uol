package br.com.felipejdias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipejdias.domain.CodinomesDisponiveis;
import br.com.felipejdias.domain.JogadoresEntity;
import br.com.felipejdias.domain.TipoArquivo;

@Repository
public interface JogadoresRepository extends JpaRepository<JogadoresEntity, Long>{
	
	@Query("SELECT new br.com.felipejdias.domain.CodinomesDisponiveis(c.cdCodinome, c.nmCodinome, c.cdGrupo) FROM CodinomesEntity c"
			+ " WHERE cdGrupo IN :tipoArquivo"
			+ " AND NOT EXISTS "
			+ "(SELECT 1 FROM JogadoresEntity j "
			+ " WHERE j.cdCodinome IN (c.cdCodinome))")
	public List<CodinomesDisponiveis> verificaCodinomeDisponivel(@Param(value = "tipoArquivo") TipoArquivo tipoArquivo);

}
