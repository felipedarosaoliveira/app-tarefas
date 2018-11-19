package br.com.cursojava.apptarefas.projeto;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cursojava.apptarefas.utils.AbstractBean;

@ManagedBean(name = "projetoBean")
@ViewScoped
public class ProjetoBean extends AbstractBean{

	
	
	
	private ProjetoFacade facade = new ProjetoFacade();
	private List<Projeto> projetos;
	private Projeto projetoAtual = facade.novoProjeto();
	private String oid;
	private boolean novo = true;
	private boolean podeEditar = true;
	private String teste = "testando123";
	
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
				FacesMessage message = new FacesMessage("Id invï¿½lido");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, message);
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
				addMensagem("Nï¿½o foi possï¿½vel remover o contato", FacesMessage.SEVERITY_ERROR);
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


	public String getTeste() {
		return teste;
	}


	public void setTeste(String teste) {
		this.teste = teste;
	}
	
}
