package br.com.cursojava.apptarefas.tarefa;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cursojava.apptarefas.projeto.Projeto;
import br.com.cursojava.apptarefas.situacao.Situacao;
import br.com.cursojava.apptarefas.usuario.Usuario;
import br.com.cursojava.apptarefas.utils.AbstractBean;
import br.com.cursojava.apptarefas.utils.Sistema;

@ManagedBean
@ViewScoped
public class TarefaBean extends AbstractBean {

	private TarefaFacade facade = new TarefaFacade();
	private Tarefa tarefaAtual = facade.novaTarefa();
	private String oid;
	private boolean novo = true;
	private boolean podeEditar = true;
	private List<Tarefa> tarefas;
	private List<Situacao> situacoes;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
		if ("novo".equals(oid)) {
			tarefaAtual = facade.novaTarefa();
			novo();
		} else {
			try {
				Integer id = Integer.parseInt(oid);
				tarefaAtual = facade.carregarTarefa(id);
				novo = false;
			} catch (NumberFormatException ex) {
				addMensagem("Id inv�lido", FacesMessage.SEVERITY_ERROR);
			}
		}
	}

	public Integer getId() {
		return tarefaAtual != null ? tarefaAtual.getId() : null;
	}

	public void setId(Integer id) {
		if (tarefaAtual != null) {
			tarefaAtual.setId(id);
		}
	}

	public String getNome() {
		return tarefaAtual != null ? tarefaAtual.getNome() : null;
	}

	public void setNome(String nome) {
		if (tarefaAtual != null) {
			tarefaAtual.setNome(nome);
		}
	}

	public String getDescricao() {
		return tarefaAtual != null ? tarefaAtual.getDescricao() : null;
	}

	public void setDescricao(String descricao) {
		if (tarefaAtual != null) {
			tarefaAtual.setDescricao(descricao);
		}
	}

	public Projeto getProjeto() {
		return tarefaAtual != null ? tarefaAtual.getProjeto() : null;
	}

	public Situacao getSituacao() {
		return tarefaAtual != null ? tarefaAtual.getSituacao() : null;
	}

	public void setSituacao(Situacao situacao) {
		if (tarefaAtual != null) {
			tarefaAtual.setSituacao(situacao);
		}
	}

	public Usuario getUsuario() {
		return tarefaAtual != null ? tarefaAtual.getUsuario() : null;
	}

	public void setUsuario(Usuario usuario) {
		if (tarefaAtual != null) {
			tarefaAtual.setUsuario(usuario);
		}

	}

	public boolean isNovo() {
		return novo;
	}

	public List<Situacao> getSituacoes() {
		if (situacoes == null || situacoes.isEmpty()) {
			situacoes = facade.carregarSituacao();
		}
		return situacoes;
	}

	public void setSituacoes(List<Situacao> situacoes) {
		this.situacoes = situacoes;
	}

	public List<Tarefa> getTarefas() {
		if (tarefas == null || tarefas.isEmpty()) {
			tarefas = facade.buscarPorProjeto(projetoAtual);
		}
		return tarefas;
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
				addMensagem("Não foi possśvel remover a tarefa", FacesMessage.SEVERITY_ERROR);
			}
		}
	}

	public void editar() {
		this.podeEditar = true;
	}

	public void novo() {
		this.tarefaAtual = facade.novaTarefa();
		novo = true;
		this.tarefaAtual.setProjeto(projetoAtual);
		editar();
	}

	private void addMensagem(String mensagem, Severity severidade) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(mensagem);
		message.setSeverity(severidade);
		context.addMessage(null, message);
	}

	Map<String, Situacao> situacoesPadrao = Sistema.getSituacoesPadrao();
	List<Situacao> listaSituacoes = getSituacoes();

	public List<Tarefa> getBacklog() {
		return facade.listaBacklog(projetoAtual);
	}

	public int getQtdBacklog() {
		return getBacklog().size();
	}

	public List<Tarefa> getPriorizada() {
		return facade.listaPriorizada(projetoAtual);
	}

	public int getQtdPriorizada() {
		return getPriorizada().size();
	}

	public List<Tarefa> getDesenvolvimento() {
		return facade.listaDesenvolvimento(projetoAtual);
	}

	public int getQtdDesenvolvimento() {
		return getDesenvolvimento().size();
	}

	public List<Tarefa> getFinalizada() {
		return facade.listaFinalizada(projetoAtual);
	}

	public int getQtdFinalizada() {
		return getFinalizada().size();
	}

	private Projeto projetoAtual;

	@PostConstruct
	public void carregarDados() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		if (session != null) {
			setProjetoAtual((Projeto) session.getAttribute("projetoAtual"));
			tarefas = facade.buscarPorProjeto(projetoAtual);
			this.tarefaAtual.setProjeto(projetoAtual);
		}

	}

	public Projeto getProjetoAtual() {
		return projetoAtual;
	}

	public void setProjetoAtual(Projeto projetoAtual) {
		this.projetoAtual = projetoAtual;
	}

	public String editarTarefa() {
		this.podeEditar = true;
		return "./tarefa/formulario.xhtml";
	}

}