package br.com.cursojava.apptarefas.usuario;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioFacade {

	private UsuarioRepositorio ur = new UsuarioRepositorio();

	private Usuario novoUsuario() {
		return new Usuario();
	}
	//buscar todos
	public List<Usuario> carregarUsuarios() {
		return ur.buscarTodos();
	}
	
	public boolean editar(Usuario usuario) {
		return ur.atualizar(usuario);
	}
	
	public boolean adicionar(Usuario usuario) {
		return ur.inserir(usuario);
	}
	
	public boolean remover(Integer id) {
		return ur.remover(id);
	}
	
	public boolean isNomeValido(String nome) {
		//não pode ser igual a outro usuario
		return nome != null && nome.length() <= 120;
	}
	
	public boolean isEmailValido(String email) {
		boolean isEmail = false;
		isEmail = isArroba(email);
		return email != null && email.length() <= 120 && !"".equals(email.trim()) && isEmail ;
	}
	
	private boolean isArroba(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isSenhaValida(String senha) {
		//mínimo 6 caracteres
		return senha != null && senha.length() >= 6;
	}
}	
