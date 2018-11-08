package br.com.cursojava.apptarefas.situacao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Situacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private String tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "\"dataHoraCriacao\"", nullable = false)
	private Date dataHoraCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "\"dataHoraAtualizacao\"",nullable = false)
	private Date dataHoraAtualizacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "\"dataHoraRemocao\"")
	private Date dataHoraRemocao;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private String status;
	
	public Situacao() {
		super();
	}
	
	public Situacao(Integer id, String nome, String tipo, Date dataHoraCriacao, Date dataHoraAtualizacao,
			Date dataHoraRemocao, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.dataHoraCriacao = dataHoraCriacao;
		this.dataHoraAtualizacao = dataHoraAtualizacao;
		this.dataHoraRemocao = dataHoraRemocao;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getDataHoraCriacao() {
		return dataHoraCriacao;
	}
	public void setDataHoraCriacao(Date dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}
	public Date getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
	public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}
	public Date getDataHoraRemocao() {
		return dataHoraRemocao;
	}
	public void setDataHoraRemocao(Date dataHoraRemocao) {
		this.dataHoraRemocao = dataHoraRemocao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Situacao other = (Situacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Situacao [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", dataHoraCriacao=" + dataHoraCriacao
				+ ", dataHoraAtualizacao=" + dataHoraAtualizacao + ", dataHoraRemocao=" + dataHoraRemocao + ", status="
				+ status + "]";
	}
	
	
	
}
