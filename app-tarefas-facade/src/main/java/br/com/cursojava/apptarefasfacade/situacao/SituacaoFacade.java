package br.com.cursojava.apptarefasfacade.situacao;

import java.util.Date;
import java.util.List;

import br.com.apptarefadao.situacao.Situacao;
import br.com.apptarefadao.situacao.SituacaoRepositorio;
import br.com.cursojava.apptarefasfacade.utils.ValidationResult;

public class SituacaoFacade {

	private SituacaoRepositorio repositorio = new SituacaoRepositorio();
	private SituacaoBusiness business = new SituacaoBusiness();

	public Situacao novaSituacao() {
		System.out.println("Passei aqui");
		return new Situacao();
	}

	public Situacao carregarSituacao(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public List<Situacao> carregarSituacoes() {
		return repositorio.buscarTodos();
	}

	public ValidationResult salvar(Situacao situacaoAtual) {
		boolean ok = false;
		situacaoAtual.setDataHoraAtualizacao(new Date());
		ValidationResult result = business.validar(situacaoAtual);
		if (result.isOk()) {
			if (situacaoAtual.getId() == null) {
				ok = repositorio.inserir(situacaoAtual);
				System.out.println("Inserindo situação no Banco: " + situacaoAtual.getNome());
			} else {
				ok = repositorio.atualizar(situacaoAtual);
				System.out.println("Atualizando situação no Banco: " + situacaoAtual.getNome());
			}
			if (!ok) {
				result.addErrorMessage("persistencia", "Não foi possível salvar os dados do projeto");
			}
		}
		return result;
	}

	public boolean removerSituacao(Situacao situacaoAtual) {
		return repositorio.remover(situacaoAtual.getId());

	}

}
