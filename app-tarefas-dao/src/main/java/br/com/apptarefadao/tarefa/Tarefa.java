package br.com.apptarefadao.tarefa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.apptarefadao.projeto.Projeto;
import br.com.apptarefadao.situacao.Situacao;
import br.com.apptarefadao.usuario.Usuario;

@Entity
@Table(name = "tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome;

	@Column
	private String descricao;

	@Column(name = "\"dataHoraCriacao\"")
	private Date dataHoraCriacao;

	@Column(name = "\"dataHoraAtualizacao\"")
	private Date dataHoraAtualizacao;

	@Column(name = "\"dataHoraRemocao\"")
	private Date dataHoraRemocao;

	@ManyToOne
	@JoinColumn(name = "\"projetoId\"")
	private Projeto projeto;

	@ManyToOne
	@JoinColumn(name = "\"situacaoId\"")
	private Situacao situacao;

	@ManyToOne
	@JoinColumn(name = "\"usuarioId\"")
	private Usuario usuario;

	public Tarefa() {
		super();
	}

	public Tarefa(Integer id, String nome, String descricao, Date dataHoraCriacao, Date dataHoraAtualizacao,
			Projeto projeto, Situacao situacao, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataHoraCriacao = dataHoraCriacao;
		this.dataHoraAtualizacao = dataHoraAtualizacao;
		this.projeto = projeto;
		this.situacao = situacao;
		this.usuario = usuario;
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projetos) {
		this.projeto = projetos;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuarios) {
		this.usuario = usuarios;
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

	@Override
	public String toString() {
		return "TarefasEntidade [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", projetos=" + projeto
				+ ", situacao=" + situacao + ", usuarios=" + usuario + "]";
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
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
