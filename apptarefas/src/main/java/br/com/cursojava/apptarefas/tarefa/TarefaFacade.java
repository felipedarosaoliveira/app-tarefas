package br.com.cursojava.apptarefas.tarefa;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.apptarefadao.projeto.Projeto;
import br.com.apptarefadao.situacao.Situacao;
import br.com.apptarefadao.tarefa.Tarefa;
import br.com.apptarefadao.tarefa.TarefaRepositorio;
import br.com.apptarefadao.usuario.Usuario;
import br.com.cursojava.apptarefas.projeto.ProjetoFacade;
import br.com.cursojava.apptarefas.situacao.SituacaoFacade;
import br.com.cursojava.apptarefas.usuario.UsuarioFacade;
import br.com.cursojava.utils.Sistema;
import br.com.cursojava.utils.ValidationResult;
import br.com.cursojava.tarefa.TarefaBusiness;

public class TarefaFacade {

	private TarefaRepositorio repositorio = new TarefaRepositorio();
	private TarefaBusiness business = new TarefaBusiness();

	public Tarefa novaTarefa() {
		return new Tarefa();
	}

	public Tarefa carregarTarefa(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public List<Tarefa> carregarTarefas(Projeto projeto) {
		return repositorio.buscarPorProjeto(projeto);
	}

	public ValidationResult salvar(Tarefa tarefaAtual) {
		boolean resultado = false;
		tarefaAtual.setDataHoraAtualizacao(new Date());
		ValidationResult result = business.validar(tarefaAtual);
		if (result.isOk()) {
			if (tarefaAtual.getId() == null) {
				tarefaAtual.setDataHoraCriacao(new Date());
				resultado = repositorio.inserir(tarefaAtual);
			} else {
				resultado = repositorio.atualizar(tarefaAtual);
			}
			if (!resultado) {
				result.addErrorMessage("persistencia", "Não foi possível salvar os dados da tarefa");
			}
		}
		return result;
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

	public List<Tarefa> listaBacklog(Projeto projeto) {
		List<Tarefa> listaBacklog = carregarTarefas(projeto).stream()
				.filter(t -> t.getSituacao().equals(situacoesPadrao.get("Backlog"))).collect(Collectors.toList());
		return listaBacklog;
	}

	public List<Tarefa> listaPriorizada(Projeto projeto) {
		List<Tarefa> listaPriorizada = carregarTarefas(projeto).stream()
				.filter(t -> t.getSituacao().equals(situacoesPadrao.get("Priorizada"))).collect(Collectors.toList());
		return listaPriorizada;
	}

	public List<Tarefa> listaDesenvolvimento(Projeto projeto) {
		List<Tarefa> listaEmDesenvolvimento = carregarTarefas(projeto).stream()
				.filter(t -> t.getSituacao().equals(situacoesPadrao.get("Em desenvolvimento")))
				.collect(Collectors.toList());
		return listaEmDesenvolvimento;
	}

	public List<Tarefa> listaFinalizada(Projeto projeto) {
		List<Tarefa> listaFinalizada = carregarTarefas(projeto).stream()
				.filter(t -> t.getSituacao().equals(situacoesPadrao.get("Finalizada"))).collect(Collectors.toList());
		return listaFinalizada;
	}

	public List<Tarefa> buscarPorProjeto(Projeto projetoAtual) {
		return repositorio.buscarPorProjeto(projetoAtual);
	}

}
