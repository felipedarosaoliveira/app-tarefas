package br.com.cursojava.apptarefasfacade.usuario;

import br.com.apptarefadao.usuario.Usuario;
import br.com.cursojava.apptarefasfacade.utils.Sistema;
import br.com.cursojava.apptarefasfacade.utils.ValidationResult;

public class UsuarioBusiness {

	public ValidationResult validar(Usuario usuario) {
		ValidationResult resultado = new ValidationResult();

		String nome = usuario.getNome();
		if (nome == null || "".equals(nome.trim())) {
			resultado.addErrorMessage("nome", "O campo nome é Obrigatório.");
		} else if (nome.length() < 3) {
			resultado.addErrorMessage("nome", "O campo nome deve possuir ao menos 3 caracteres.");
		}

		String email = usuario.getEmail();
		if (!email.contains("@")) {
			resultado.addErrorMessage("email", "O formato de email não é válido.");
		}

		String senha = usuario.getSenha();
		if (senha.length() < 8) {
			resultado.addErrorMessage("senha", "A senha deve conter pelo menos 8 caracteres");
		}

		System.out.println(usuario.getSenha());
		try {
			if (usuario == null || "d41d8cd98f00b204e9800998ecf8427e".equals(usuario.getSenha().trim())) {
				resultado.addErrorMessage("Senha", "O campo Senha é obrigatório");
			}
		} catch (NullPointerException e) {
			resultado.addErrorMessage("Senha", "O campo Senha é obrigatório");
		}
		return resultado;
	}

	public ValidationResult autenticar(Usuario usuario, String senha) {
		ValidationResult resultado = new ValidationResult();
		if (usuario == null) {
			resultado.addErrorMessage("email", "email invalido");
		} else if (!usuario.getSenha().equals(Sistema.gerarHash(senha))) {
			resultado.addErrorMessage("senha", "senha inválida");
		}
		return resultado;

	}

}
