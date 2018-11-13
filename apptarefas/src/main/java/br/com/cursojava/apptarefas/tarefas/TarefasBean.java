package br.com.cursojava.apptarefas.tarefas;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.cursojava.apptarefas.projeto.Projeto;
import br.com.cursojava.apptarefas.situacao.Situacao;
import br.com.cursojava.apptarefas.usuario.Usuario;

@ManagedBean
@SessionScoped
public class TarefasBean {

	private Integer id;
	private String nome;
	private String descricao;
	private Projeto projeto;
	private Situacao situacao;
	private Usuario responsavel;
	// listas para selecionar na view
	private List<Projeto> projetos;
	private List<Tarefas> tarefas;
	private List<Usuario> usuarios;
	private List<Situacao> situacaoLista;

	private TarefasFacade facade = new TarefasFacade();
	private Tarefas tarefaAtual = facade.novaTarefa();
	private String oid;
	private boolean novo = true;
	private boolean podeEditar = true;

	@PostConstruct
	public void ini() {
		//lógica para ler os dados e imprimir na tela após carregamento da xhtml 
		getTarefas();
		contador(0);
	}
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
		if ("novo".equals(oid)) {
			novo();
		} else {
			try {
				Integer id = Integer.parseInt(oid);
				tarefaAtual = facade.carregarTarefa(id);
				novo = false;
			} catch (NumberFormatException ex) {
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage("Id inválido");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, message);
			}
		}
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

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public List<Projeto> getProjetos() {
		if (projetos == null || projetos.isEmpty()) {
			projetos = facade.carregarProjetos();
		}
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Tarefas> getTarefas() {
		if (tarefas == null || tarefas.isEmpty()) {
			tarefas = facade.carregarTarefas();
		}
		return tarefas;
	}

	public void setTarefas(List<Tarefas> tarefas) {
		this.tarefas = tarefas;
	}

	public boolean isNovo() {
		return novo;
	}
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null || usuarios.isEmpty()) {
			usuarios = facade.carregarUsuarios();
		}
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Situacao> getSituacaoLista() {
		if(situacaoLista == null || situacaoLista.isEmpty()) {
			situacaoLista = facade.carregarSituacao();
		}
		return situacaoLista;
	}

	public void setSituacaoLista(List<Situacao> situacaoLista) {
		this.situacaoLista = situacaoLista;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public boolean isPodeEditar() {
		return podeEditar;
	}

	public void setPodeEditar(boolean podeEditar) {
		this.podeEditar = podeEditar;
	}

	public String listar() {
		novo();
		return "./lista.jsf";
	}

	public void salvar() {
		boolean ok = false;
		if (tarefaAtual != null) {
			ok = facade.salvar(tarefaAtual);
		}
		if (ok) {
			addMensagem("Tarefa salva com sucesso", FacesMessage.SEVERITY_INFO);
			novo = false;
			podeEditar = false;
		} else {
			addMensagem("Não foi possível salvar a tarefa", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void remover() {
		boolean ok = false;
		if (tarefaAtual != null && !novo) {
			ok = facade.removerTarefa(tarefaAtual);
			if (ok) {
				addMensagem("Tarefa Removida com Sucesso", FacesMessage.SEVERITY_INFO);
				novo();
			} else {
				addMensagem("Não foi possível remover a tarefa", FacesMessage.SEVERITY_ERROR);
			}
		}
	}

	public void editar() {
		this.podeEditar = true;
	}

	public void novo() {
		this.tarefaAtual = facade.novaTarefa();
		novo = true;
		editar();
	}
	
	//verifica quantas tarefas têm em cada situação
	public int contador(Situacao backlog, Situacao priorizada, Situacao emAndamento, Situacao finalizada) {
		return = facade.contador(backlog, priorizada, emAndamento,  finalizada);
	}
	
	
	
	
	private void addMensagem(String mensagem, Severity severidade) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(mensagem);
		message.setSeverity(severidade);
		context.addMessage(null, message);
	}
	
	
	

}
