package br.com.cursojava.apptarefas.usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cursojava.apptarefas.utils.AppSession;
import br.com.cursojava.apptarefas.utils.AppSessionImpl;
import br.com.cursojava.apptarefas.utils.ValidationResult;

@ManagedBean
@ViewScoped
public class LoginBean {

	private String email;
	private String senha;
	private UsuarioFacade facade = new UsuarioFacade();
	
	
	
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
		HttpSession httpSession = (HttpSession) ctx.getExternalContext().getSession(true);
		AppSession session = new AppSessionImpl(httpSession);
		ValidationResult result = facade.autenticar(email,senha, session);
		if(result.isOk()) {			
			return "index.xhtml?faces-redirect=true";
		}else{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Inv�lido",
					"Email ou senha inv�lidos");
			ctx.addMessage(null, msg);
			return null;
		}
	}
	
	public String logout(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);		
			session.invalidate();
			return "/login.jsf?faces-redirect=true";		
	}
		
}