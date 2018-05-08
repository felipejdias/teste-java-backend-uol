package br.com.felipejdias.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * Entidade JPA que representa a tablea de codinomes
 * 
 *  
 * @author Felipe Jaconis
 * 
 * @see 
 * 
 * {@link Entity}
 * 
 */
@Entity
@Table(name = "TB_CODINOMES", uniqueConstraints={@UniqueConstraint(columnNames={"NM_CODINOME", "CD_GRUPO"})})
@EntityListeners(AuditingEntityListener.class)
public class CodinomesEntity implements Serializable{
	
	private static final long serialVersionUID = 3532553014040436838L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_CODINOME")
	private long cdCodinome;
	
	@NotNull
	@Column(name = "NM_CODINOME")
  	private String nmCodinome;
	
	@NotNull
	@Enumerated
	@Column(name = "CD_GRUPO")
	private TipoArquivo cdGrupo;
	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private Date dtInclusao;
	
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private Date dtAlteracao;

	public long getCdCodinome() {
		return cdCodinome;
	}

	public void setCdCodinome(long cdCodinome) {
		this.cdCodinome = cdCodinome;
	}

	public String getNmCodinome() {
		return nmCodinome;
	}

	public void setNmCodinome(String nmCodinome) {
		this.nmCodinome = nmCodinome;
	}

	public TipoArquivo getCdGrupo() {
		return cdGrupo;
	}

	public void setCdGrupo(TipoArquivo cdGrupo) {
		this.cdGrupo = cdGrupo;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
	
}
