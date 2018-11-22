package br.com.cursojava.apptarefas.usuario;

import java.util.Date;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import br.com.cursojava.apptarefas.utils.Sistema;

public class LoginBean {
		
	private String email;
	private String senha;
	private boolean ok= false;
	Usuario usuario = new Usuario();
	
	public String autenticar() {
		
		return null;
	}
	

}
