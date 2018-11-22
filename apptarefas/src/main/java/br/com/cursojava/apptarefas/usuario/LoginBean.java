package br.com.cursojava.apptarefas.usuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cursojava.apptarefas.utils.Sistema;

public class LoginBean {

	private String email;
	private String senha;
	Usuario usuario = new Usuario();

	public String autenticar() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		if (usuario.getEmail().equals(email) && usuario.getSenha().equals(Sistema.gerarHash(senha))) {
			HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
			session.setAttribute("usuarioLogado", usuario);
			return "index.xhtml?faces-redirect=true";
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Inválido",
					"Email ou senha inválidos");
			ctx.addMessage(null, msg);
		}
		return null;
	}

}
