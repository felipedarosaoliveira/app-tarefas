package br.com.cursojava.apptarefas.projeto;

import java.util.List;

public class ProjetoFacade {

	private RepositorioProjeto repositorio = new RepositorioProjeto();

	public Projeto novoProjeto() {
		return new Projeto();
	}

	public Projeto carregarProjeto(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public List<Projeto> carregarProjetos() {
		return repositorio.buscarTodos();
	}

	public boolean salvar(Projeto projetoAtual) {
		return repositorio.inserir(projetoAtual);
	}

	public boolean removerProjeto(Projeto projetoAtual) {
		return repositorio.remover(projetoAtual.getId());
	}

}
