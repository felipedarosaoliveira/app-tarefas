package br.com.cursojava.apptarefas.usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cursojava.apptarefas.utils.AppSession;
import br.com.cursojava.apptarefas.utils.ValidationResult;

@ManagedBean
@ViewScoped
public class LoginBean {

	private String email;
	private String senha;
	private UsuarioFacade facade = new UsuarioFacade();
	private AppSession session;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public String autenticar() {
		FacesContext ctx = FacesContext.getCurrentInstance();		
		ValidationResult result = facade.autenticar(email,senha, session);
		if(result.isOk()) {			
			return "index.xhtml?faces-redirect=true";
		}else{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Inválido",
					"Email ou senha inválidos");
			ctx.addMessage(null, msg);
			return null;
		}
	}
	
	
}
