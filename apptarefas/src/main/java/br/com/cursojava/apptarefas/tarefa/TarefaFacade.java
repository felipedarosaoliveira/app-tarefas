package br.com.cursojava.apptarefas.tarefa;

import java.util.List;

import br.com.cursojava.apptarefas.projeto.Projeto;
import br.com.cursojava.apptarefas.situacao.Situacao;
import br.com.cursojava.apptarefas.usuario.Usuario;

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

	public List<Projeto> carregarProjetos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Usuario> carregarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Situacao> carregarSituacao() {
		// TODO Auto-generated method stub
		return null;
	}
}

