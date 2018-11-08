package br.com.cursojava.apptarefas.usuario;

import java.util.List;

public class UsuarioFacade {
	
	public boolean isNomeValido(String nome) {
		//não pode ser igual a outro usuario
		return nome != null && nome.length() <= 120;
	}
	
	public boolean isEmailValido() {
		return email != null && email.;
	}
	
	public boolean isSenhaValida(String senha) {
		//mínimo 6 caracteres
		return senha != null && senha.length() >= 6;
	}
	
}	
