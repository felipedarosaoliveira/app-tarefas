package br.com.cursojava.usuario;

import br.com.apptarefadao.usuario.Usuario;
<<<<<<< HEAD:apptarefas/src/main/java/br/com/cursojava/apptarefas/usuario/UsuarioBusiness.java
import br.com.cursojava.apptarefasfacade.utils.Sistema;
import br.com.cursojava.apptarefasfacade.utils.ValidationResult;
=======
import br.com.cursojava.utils.Sistema;
import br.com.cursojava.utils.ValidationResult;
>>>>>>> f08cdc3d34af9118c8d24617e38c6f91be9206de:app-tarefas-business/src/main/java/br/com/cursojava/usuario/UsuarioBusiness.java

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
