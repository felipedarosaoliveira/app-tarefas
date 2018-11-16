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
	
	public boolean salvar(Tarefa tarefaAtual) {
		boolean resultado = false;
		if(tarefaAtual.getId() == null) {
			resultado = repositorio.inserir(tarefaAtual);
			System.out.println("Inserindo tarefa no Banco: " + tarefaAtual.getNome());
		}else {
			resultado = repositorio.atualizar(tarefaAtual);
			System.out.println("Atualizando tarefa no Banco: " + tarefaAtual.getNome());
		}
		return resultado;
	}
	public boolean removerTarefa(Tarefa tarefaAtual) {
		return repositorio.remover(tarefaAtual.getId());
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

