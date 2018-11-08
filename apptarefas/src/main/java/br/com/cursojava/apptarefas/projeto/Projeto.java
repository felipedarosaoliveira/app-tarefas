package br.com.cursojava.apptarefas.projeto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projetos")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private String status;
	@Column(name="dataHoraCriacao")
	private Date DataHoraCriacao;
	@Column(name="dataHoraAtualizacao")
	private Date DataHoraAtualizacao;
	@Column(name="dataHoraFim")
	private Date DataHoraFim;

	public Projeto() {
		super();
	}

	public Projeto(Integer id, String nome, String descricao, String status, Date dataHoraCriacao,
			Date dataHoraAtualizacao, Date dataHoraFim) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
		DataHoraCriacao = dataHoraCriacao;
		DataHoraAtualizacao = dataHoraAtualizacao;
		DataHoraFim = dataHoraFim;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataHoraCriacao() {
		return DataHoraCriacao;
	}

	public void setDataHoraCriacao(Date dataHoraCriacao) {
		DataHoraCriacao = dataHoraCriacao;
	}

	public Date getDataHoraAtualizacao() {
		return DataHoraAtualizacao;
	}

	public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
		DataHoraAtualizacao = dataHoraAtualizacao;
	}

	public Date getDataHoraFim() {
		return DataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		DataHoraFim = dataHoraFim;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", status=" + status
				+ ", DataHoraCriacao=" + DataHoraCriacao + ", DataHoraAtualizacao=" + DataHoraAtualizacao
				+ ", DataHoraFim=" + DataHoraFim + "]";
	}

}
