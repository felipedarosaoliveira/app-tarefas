package br.com.cursojava.apptarefas.tarefa;

import java.util.List;

public class TarefaFacade {
	
	private TarefaRepositorio repositorio = new TarefaRepositorio();
	
	
	public Tarefa novaTarefa() {
		return new Tarefa();
	}
	
	public Tarefa carregarTarefa(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public List<Tarefa> carregarTarefas() {
		return repositorio.buscarTodos();
	}
	
	public boolean salvarTarefa(Tarefa tarefaAtual) {
		return repositorio.salvar(tarefaAtual);
		
	}
	public boolean removerTarefa(Tarefa tarefaAtual) {
		return repositorio.remover(tarefaAtual.getId());

	}
	
	public boolean editarTarefa(Tarefa tarefaAtual) {
		return repositorio.editar(tarefaAtual);
	}
	
	public List<Tarefa> buscarSituacaoTarefa(String situacao) {
		return repositorio.buscarPorSituacao(situacao);
	}
}

