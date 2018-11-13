package br.com.cursojava.apptarefas.usuario;


import java.util.List;

public class UsuarioFacade {

	private UsuarioRepositorio ur = new UsuarioRepositorio();

	public Usuario novoUsuario() {
		return new Usuario();
	}
	//buscar todos
	public Usuario carregarUsuario(Integer id) {
		return ur.buscarPorId(id);
	}
	
	public List<Usuario> carregarUsuarios() {
		return ur.buscarTodos();
	}
	public boolean editar(Usuario usuario) {
		return ur.atualizar(usuario);
	}
	
	public boolean salvar(Usuario usuario) {
		return ur.inserir(usuario);
	}
	
	public boolean removerContato(Usuario usuario) {
		return ur.remover(usuario.getId());
	}
	
	public boolean isNomeValido(String nome) {
		//não pode ser igual a outro usuario
		return nome != null && nome.length() <= 120;
	}
	
	public boolean isEmailValido(String email) {
		return email != null && email.length() <= 120 && !"".equals(email.trim());
	}
	
	public boolean isSenhaValida(String senha) {
		return senha != null && senha.length() >= 6;
	}
}	

