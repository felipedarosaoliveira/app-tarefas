package br.com.cursojava.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepUsuario {
	
	private static List<Usuario>lista = new ArrayList<>();
	private static Integer count = 1;
	static{
		lista.add(new Usuario(count++, "Fredy"));
		lista.add(new Usuario(count++, "Mary"));
		lista.add(new Usuario(count++, "Lary"));
	}
	
	public List<Usuario> buscarTodos(){
		return lista;
	}
	
	public Usuario buscarPorId(Integer id){
		Usuario user = null;
		for (Usuario atual : lista) {
			if(atual != null && id.equals(atual.getId())){
				user = atual;
				break;
			}
		}
		return user;
	}
	
	public boolean salvar(Usuario user){
		boolean resultado = false;
		if(user != null){
			if(user.getId() == null){
				resultado = inserir(user);
			}else{
				resultado = atualizar(user);
			}
		}
		return resultado;
	}
	
	private boolean atualizar(Usuario user) {
		boolean resultado = false;
		int idx = lista.indexOf(user);
		if(idx > -1){
			lista.set(idx, user);
			resultado = true;
		}
		return resultado;
	}

	private boolean inserir(Usuario user) {
		user.setId(count++);
		return lista.add(user);
	}
	
	public boolean remover(Integer id){
		int qt = lista.size();
		lista=lista.stream().filter(c -> !id.equals(c.getId())).collect(Collectors.toList());
		return qt > lista.size();
	}
}
