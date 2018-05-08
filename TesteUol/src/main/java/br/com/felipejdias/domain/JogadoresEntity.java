package br.com.felipejdias.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Entidade JPA que representa a tablea de jogadores
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
@Table(name = "TB_JOGADORES", uniqueConstraints={@UniqueConstraint(columnNames={"CD_CODINOME"})})
@EntityListeners(AuditingEntityListener.class)
public class JogadoresEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_JOGADOR")
	private long cdJogador;
	
	
	@Column(name = "NM_JOGADOR", nullable = false, length = 150)
	@NotNull
	@NotBlank
	private String nmJogador;
	
	@Column(name = "DS_EMAIL")
    @NotNull(message="Insera um e-mail váliado")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
	private String dsEmail;
	
	@Column(name = "NR_TELEFONE", nullable = true)
	private String nrTelefone;
	
	@OneToOne
	@JoinColumn(name = "CD_CODINOME")
	private CodinomesEntity cdCodinome;
	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private Date dtInclusao;
	
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private Date dtAlteracao;
    
    private TipoArquivo arquivoSelecionado;
        
	public long getCdJogador() {
		return cdJogador;
	}

	public void setCdJogador(long cdJogador) {
		this.cdJogador = cdJogador;
	}

	public String getNmJogador() {
		return nmJogador;
	}

	public void setNmJogador(String nmJogador) {
		this.nmJogador = nmJogador;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public CodinomesEntity getCdCodinome() {
		return cdCodinome;
	}

	public void setCdCodinome(CodinomesEntity cdCodinome) {
		this.cdCodinome = cdCodinome;
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

	public TipoArquivo getArquivoSelecionado() {
		return arquivoSelecionado;
	}

	public void setArquivoSelecionado(TipoArquivo arquivoSelecionado) {
		this.arquivoSelecionado = arquivoSelecionado;
	}

}
