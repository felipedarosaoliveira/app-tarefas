package br.com.cursojava.apptarefas.usuario;

import java.util.List;

public class UsuarioFacade {

	private UsuarioRepositorio ur = new UsuarioRepositorio();

	//buscar todos
	public List<Usuario> buscarTodos() {
		return ur.buscarTodos();
	}
	
	//buscar por id
	public Usuario buscarPorId(Integer id) {
		if(id != null && id > 0) {
			return ur.buscarPorId(id);
		}else {
			return null;
		}
	}
	
	public boolean editar(Usuario usuario) {
		return ur.atualizar(usuario);
	}
	
	public boolean adicionar(Usuario usuario) {
		return ur.inserir(usuario);
	}
	
	public boolean isNomeValido(String nome) {
		//não pode ser igual a outro usuario
		return nome != null && nome.length() <= 120;
	}
	
	public boolean isEmailValido() {
		//mínimo 6 caracteres
		return false;
	}
	
	public boolean isSenhaValida(String senha) {
		return senha != null && senha.length() >= 6;
	}
}	
