package br.com.cursojava.apptarefas.tarefa;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.cursojava.apptarefas.projeto.Projeto;
import br.com.cursojava.apptarefas.projeto.ProjetoFacade;
import br.com.cursojava.apptarefas.situacao.Situacao;
import br.com.cursojava.apptarefas.situacao.SituacaoFacade;
import br.com.cursojava.apptarefas.usuario.Usuario;
import br.com.cursojava.apptarefas.usuario.UsuarioFacade;
import br.com.cursojava.apptarefas.utils.Sistema;

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
		if (tarefaAtual.getId() == null) {
			resultado = repositorio.inserir(tarefaAtual);
		} else {
			resultado = repositorio.atualizar(tarefaAtual);
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
		ProjetoFacade pFacade = new ProjetoFacade();
		return pFacade.carregarProjetos();
	}

	public List<Usuario> carregarUsuarios() {
		UsuarioFacade uFacade = new UsuarioFacade();
		return uFacade.carregarUsuarios();
	}

	public List<Situacao> carregarSituacao() {
		SituacaoFacade sFacade = new SituacaoFacade();
		return sFacade.carregarSituacoes();
	}

	public long contarTarefa() {
		return repositorio.contar();
	}

	Map<String, Situacao> situacoesPadrao = Sistema.getSituacoesPadrao();
	List<Situacao> listaSituacoes = carregarSituacao();

	public List<Tarefa> listaBacklog() {
		List<Tarefa> listaBacklog = carregarTarefas().stream()
				.filter(t -> t.getSituacao().equals(situacoesPadrao.get("Backlog"))).collect(Collectors.toList());
		return listaBacklog;
	}

	public List<Tarefa> listaPriorizada() {
		List<Tarefa> listaPriorizada = carregarTarefas().stream()
				.filter(t -> t.getSituacao().equals(situacoesPadrao.get("Priorizada"))).collect(Collectors.toList());
		return listaPriorizada;
	}

	public List<Tarefa> listaDesenvolvimento() {
		List<Tarefa> listaEmDesenvolvimento = carregarTarefas().stream()
				.filter(t -> t.getSituacao().equals(situacoesPadrao.get("Em desenvolvimento")))
				.collect(Collectors.toList());
		return listaEmDesenvolvimento;
	}

	public List<Tarefa> listaFinalizada() {
		List<Tarefa> listaFinalizada = carregarTarefas().stream()
				.filter(t -> t.getSituacao().equals(situacoesPadrao.get("Finalizada"))).collect(Collectors.toList());
		return listaFinalizada;
	}

}
