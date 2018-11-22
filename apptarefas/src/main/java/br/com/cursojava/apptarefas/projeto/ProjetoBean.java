package br.com.cursojava.apptarefas.projeto;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cursojava.apptarefas.utils.AbstractBean;
import br.com.cursojava.apptarefas.utils.ValidationResult;

@ManagedBean(name = "projetoBean")
@ViewScoped
public class ProjetoBean extends AbstractBean{

		
	private String oid;
	private List<Projeto> projetos;
	private boolean novo = true;
	private boolean podeEditar = true;
	private ProjetoFacade facade = new ProjetoFacade();
	private Projeto projetoAtual = facade.novoProjeto();
	
	
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
				setNovo(false);
			} catch (NumberFormatException ex) {
				addMessage("ID Inválido!", FacesMessage.SEVERITY_ERROR);
			}
		}
	}
	
		
	public Integer getId() {
		return projetoAtual != null ? projetoAtual.getId():null;
	}

	public void setId(Integer id) {
		if(projetoAtual != null) {
			projetoAtual.setId(id);
		}
	}

	public String getNome() {
		return projetoAtual != null ? projetoAtual.getNome():"";
	}

	public void setNome(String nome) {
		if(projetoAtual != null) {
			projetoAtual.setNome(nome);
		}
	}

	public String getDescricao() {
		return projetoAtual != null ? projetoAtual.getDescricao():"";
	}

	public void setDescricao(String descricao) {
		if(projetoAtual != null) {
			projetoAtual.setDescricao(descricao);
		}
	}

	public ProjetoStatus getStatus() {
		return projetoAtual != null ? projetoAtual.getStatus():null;
	}

	public void setStatus(ProjetoStatus status) {
		if(projetoAtual != null) {
			projetoAtual.setStatus(status);
		}
	}

	public ProjetoStatus[] getStatusList() {
		return ProjetoStatus.values();
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
		ValidationResult result;
		if (projetoAtual != null) {
			result = facade.salvar(projetoAtual);			
			if (result.isOk()) {
				addMessage("Projeto salvo com sucesso", FacesMessage.SEVERITY_INFO);
				setNovo(false);
				setPodeEditar(false);
			} else {
				Map<String, String> messages = result.getMessages();
				for (Map.Entry<String, String> message : messages.entrySet()) {
					addMessage(message.getValue(), FacesMessage.SEVERITY_ERROR);
				}
			}
		}
	}

	public void remover() {
		boolean ok = false;
		if (projetoAtual != null && !isNovo()) {
			ok = facade.removerProjeto(projetoAtual);
			if (ok) {
				addMessage("Projeto Removido com Sucesso", FacesMessage.SEVERITY_INFO);
				novo();
			} else {
				addMessage("Nï¿½o foi possï¿½vel remover o contato", FacesMessage.SEVERITY_ERROR);
			}
		}
	}

	public void editar() {
		this.setPodeEditar(true);
	}

	public void novo() {
	System.out.println("Cliquei no novo()");
		this.projetoAtual = facade.novoProjeto();
		setNovo(true);
		editar();
	}

	

	private void addMessage(String mensagem, Severity severidade) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(mensagem);
		message.setSeverity(severidade);
		context.addMessage(null, message);
	}


	public void setPodeEditar(boolean podeEditar) {
		this.podeEditar = podeEditar;
	}


	public boolean isNovo() {
		return novo;
	}


	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public String carregarDashProjeto() {
		addSessionAttribute("projetoAtual", projetoAtual);
		return "/index.xhtml?faces-redirect=true";
	}

	
}
