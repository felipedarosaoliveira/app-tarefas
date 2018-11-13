package br.com.cursojava.apptarefas.situacao;

import java.util.List;

public class SituacaoFacade {

	private SituacaoRepositorio repositorio = new SituacaoRepositorio();

	public Situacao novaSituacao() {
		return new Situacao();
	}

	public Situacao carregarSituacao(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public List<Situacao> carregarSituacoes() {
		return repositorio.buscarTodos();
	}

	public boolean salvar(Situacao situacaoAtual) {
		boolean resultado = false;
		if( situacaoAtual.getId() == null) {
			resultado = repositorio.inserir(situacaoAtual);
			System.out.println("Inserindo situação no Banco: " + situacaoAtual.getNome());
		}else {
			resultado = repositorio.atualizar(situacaoAtual);
			System.out.println("Atualizando situação no Banco: " + situacaoAtual.getNome());
		}
		return resultado;
	}

	public boolean removerSituacao(Situacao situacaoAtual) {
		return repositorio.remover(situacaoAtual.getId());

	}

}
