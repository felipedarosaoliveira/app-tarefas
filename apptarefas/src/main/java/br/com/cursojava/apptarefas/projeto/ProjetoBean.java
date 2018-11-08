package br.com.cursojava.apptarefas.projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "projetoBean")
@ViewScoped
public class ProjetoBean {

	private Integer id;

	private String nome;

	private String descricao;

	private String status;

	private Date dataHoraCriacao;

	private Date dataHoraAtualizacao;

	private Date dataHoraFim;
	
	private List<Projeto> projetos = new ArrayList<>();

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

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	public void salvar() {
		Projeto Projeto = new Projeto(nome, descricao, status, dataHoraCriacao,	dataHoraAtualizacao, dataHoraFim);
		projetos.add(Projeto);		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage("Projeto Adicionado com sucesso");
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
//		context.addMessage("nome", mensagem);
		context.addMessage(null, mensagem);

	}

	
}
