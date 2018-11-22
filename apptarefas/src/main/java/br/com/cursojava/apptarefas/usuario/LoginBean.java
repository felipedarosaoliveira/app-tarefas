package br.com.cursojava.apptarefas.usuario;

import java.util.Date;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class LoginBean {
		
	private String email;
	private String senha;
	private boolean ok= false;
	Usuario usuario = new Usuario();
	
	
	public void login() {		
		if (email != null && senha != null) {
			ok = true;
		}
		if (ok) {
			if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha));			
			//logado
		} else {
			addMessage("Email ou senha inválidos", FacesMessage.SEVERITY_ERROR);
		}
	}	
	
	private void addMessage(String mensagem, Severity prioridade) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(mensagem);
		message.setSeverity(prioridade);
		context.addMessage(null, message);
	}

}
