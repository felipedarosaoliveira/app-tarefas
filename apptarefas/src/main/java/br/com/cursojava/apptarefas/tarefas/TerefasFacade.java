package br.com.cursojava.apptarefas.tarefas;

import java.util.List;

public class TerefasFacade {
	
	private TarefasRepositorio repositorio = new TarefasRepositorio();
	
	
	public Tarefa novaTarefa() {
		return new Tarefa();
	}
	
	public Tarefa carregarTarefa(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public List<Tarefa> carregarTarefas() {
		return repositorio.buscarTodos();
	}
	
	public Tarefa salvarTarefa(Tarefa tarefaAtual) {
		return repositorio.salvar(tarefaAtual);
		
	}
	public boolean removerTarefa(Tarefa tarefaAtual) {
		return repositorio.remover(tarefaAtual.getId());

	}
	
	public Tarefa editarTarefa(Tarefa tarefaAtual) {
		return repositorio.editar(tarefaAtual);
	}
	
	public Tarefa buscarSituacaoTarefa(Tarefa situacaoAtual) {
		return repositorio.buscarPorSituacao();
	}
}

