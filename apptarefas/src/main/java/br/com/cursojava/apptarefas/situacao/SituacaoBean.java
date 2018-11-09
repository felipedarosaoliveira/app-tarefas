package br.com.cursojava.apptarefas.situacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class SituacaoBean {
	private Integer id;
	private String nome;
	private String tipo;
	private Date dataHoraCriacao;
	private Date dataHoraAtualizacao;
	private Date dataHoraRemocao;
	private String status;
	
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
	
	private void limparCampos() {
		this.id = null;
		this.nome = "";
		this.tipo = "";
		this.dataHoraCriacao = null;
		this.dataHoraAtualizacao = null;
		this.dataHoraRemocao = null;
		this.status = "";
		
	}

}
