package br.com.cursojava.apptarefas.projeto;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "projetoBean")
@ViewScoped
public class ProjetoBean {

	private Integer id;

	private String nome;

	private String descricao;

	private ProjetoStatus status;

	private Date dataHoraCriacao;

	private Date dataHoraAtualizacao;

	private Date dataHoraFim;
	
		
	private ProjetoFacade facade = new ProjetoFacade();
	private List<Projeto> projetos;
	private Projeto projetoAtual = facade.novoProjeto();
	private String oid;
	private boolean novo = true;
	private boolean podeEditar = true;
	
	public boolean isPodeEditar() {
		return podeEditar;
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
				projetoAtual = facade.carregarProjeto(id);
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

	public ProjetoStatus getStatus() {
		return status;
	}

	public void setStatus(ProjetoStatus status) {
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
		if (projetos == null || projetos.isEmpty()) {
			projetos = facade.carregarProjetos();
		}
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	public String listar() {
		novo();
		return "./lista.jsf";
	}
	
	
	public void salvar() {
		boolean ok = false;
		if (projetoAtual != null) {
			ok = facade.salvar(projetoAtual);			
		}
		if (ok) {
			addMensagem("Projeto salvo com sucesso", FacesMessage.SEVERITY_INFO);
			novo = false;
			podeEditar = false;
		} else {
			addMensagem("Não foi possível salvar o contato", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void remover() {
		boolean ok = false;
		if (projetoAtual != null && !novo) {
			ok = facade.removerProjeto(projetoAtual);
			if (ok) {
				addMensagem("Projeto Removido com Sucesso", FacesMessage.SEVERITY_INFO);
				novo();
			} else {
				addMensagem("Não foi possível remover o contato", FacesMessage.SEVERITY_ERROR);
			}
		}
	}

	public void editar() {
		this.podeEditar = true;
	}

	public void novo() {
		this.projetoAtual = facade.novoProjeto();
		novo = true;
		editar();
	}

	

	private void addMensagem(String mensagem, Severity severidade) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(mensagem);
		message.setSeverity(severidade);
		context.addMessage(null, message);
	}
	
}
