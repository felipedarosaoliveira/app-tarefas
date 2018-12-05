package br.com.cursojava;

import java.util.ArrayList;
import java.util.List;

public class RepositorioSituacao {

	private static List<Situacao> lista = new ArrayList<>();

	private static Integer count = 1;
	static {
		lista.add(new Situacao(count++, "sITUACAO 1"));
		lista.add(new Situacao(count++, "sITUACAO 2"));
		lista.add(new Situacao(count++, "sITUACAO 3"));
	}

	public Situacao buscarPorId(Integer id) {

		return lista.get(id);
	}

	public boolean salvar(Situacao situacao) {
	return true;
	}

	public List<Situacao> buscarTodos() {

		return lista;

	}

	public boolean remover(Integer id) {
		return false;
	}

}
