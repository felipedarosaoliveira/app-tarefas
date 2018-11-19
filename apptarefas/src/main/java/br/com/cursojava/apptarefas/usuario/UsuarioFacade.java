package br.com.cursojava.apptarefas.usuario;

import java.util.List;

public class UsuarioFacade {

	private UsuarioRepositorio repositorio = new UsuarioRepositorio();

	public Usuario novoUsuario() {
		return new Usuario();
	}

	public Usuario carregarUsuario(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public boolean salvar(Usuario usuarioAtual) {
		boolean ok = false;
		if (usuarioAtual.getId() == null) {
			ok = repositorio.inserir(usuarioAtual);
		} else {
			ok = repositorio.atualizar(usuarioAtual);
		}
		return ok;
	}

	public boolean removerContato(Usuario usuarioAtual) {
		return repositorio.remover(usuarioAtual.getId());
	}

	public List<Usuario> carregarUsuarios() {
		return repositorio.buscarTodos();
	}
}
