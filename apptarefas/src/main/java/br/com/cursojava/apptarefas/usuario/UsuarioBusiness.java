package br.com.cursojava.apptarefas.usuario;

import br.com.cursojava.apptarefas.utils.Sistema;
import br.com.cursojava.apptarefas.utils.ValidationResult;

public class UsuarioBusiness {
	
	public ValidationResult validar(Usuario usuario){
		ValidationResult resultado = new ValidationResult();
		
		String nome = usuario.getNome();
		if(nome == null || "".equals(nome.trim())){
			resultado.addErrorMessage("nome", "O campo nome é Obrigatório.");
		}else if(nome.length() < 3){
			resultado.addErrorMessage("nome", "O campo nome deve possuir ao menos 3 caracteres.");
		}
		
		String email = usuario.getEmail();
		if(!email.contains("@")){
			resultado.addErrorMessage("email", "O formato de email não é válido.");
		}
		
		String senha = usuario.getSenha();
		if(senha.length() < 8){
			resultado.addErrorMessage("senha", "A senha deve conter pelo menos 8 caracteres");
		}
		
		return resultado;
	}

	public ValidationResult autenticar(Usuario usuario, String senha) {
		ValidationResult resultado = new ValidationResult();	
		if(usuario == null) {
			resultado.addErrorMessage("email", "email invalido");
		} else if (!usuario.getSenha().equals(Sistema.gerarHash(senha))) {
			resultado.addErrorMessage("senha", "senha inválida");
		}
		return resultado;
		
	}

}
