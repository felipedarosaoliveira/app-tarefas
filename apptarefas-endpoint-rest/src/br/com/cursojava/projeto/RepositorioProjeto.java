package br.com.cursojava.projeto;

import java.util.ArrayList;
import java.util.List;

public class RepositorioProjeto {
	
	private static List<Projeto>lista = new ArrayList<>();
	private static Integer count = 1;
	static{
		lista.add(new Projeto(count++, "Projeto1", "descreve Projeto1"));
		lista.add(new Projeto(count++, "Projeto2", "descreve Projeto2"));
		lista.add(new Projeto(count++, "Projeto3", "descreve Projeto3"));
		
	}

	public List<Projeto> buscarTodos() {
		System.out.println("buscarTodos");
		return lista;
	}

	public Projeto buscarPorId(Integer id) {
		System.out.println("buscarPorId");
		return lista.get(id);
		
	}

	public boolean salvar(Projeto projeto) {
		projeto.setId(count++);
		lista.add(projeto);
		System.out.println("salvar");
		return true;
	}

	public boolean remover(Integer id) {
		System.out.println("remover");
		return true;
	}

	
}
