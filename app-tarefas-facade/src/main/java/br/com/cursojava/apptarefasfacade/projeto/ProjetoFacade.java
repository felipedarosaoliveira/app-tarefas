package br.com.cursojava.apptarefasfacade.projeto;

import java.util.Date;
import java.util.List;

import br.com.apptarefadao.projeto.Projeto;
import br.com.apptarefadao.projeto.ProjetoRepositorio;
import br.com.cursojava.projeto.ProjetoBusiness;
import br.com.cursojava.utils.ValidationResult;

public class ProjetoFacade {

	private ProjetoRepositorio repositorio = new ProjetoRepositorio();
	private ProjetoBusiness business  = new ProjetoBusiness();
	public Projeto novoProjeto() {
		System.out.println("Passei aqui");
		return new Projeto();
	}

	public Projeto carregarProjeto(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public List<Projeto> carregarProjetos() {
		return repositorio.buscarTodos();
	}

	public ValidationResult salvar(Projeto projetoAtual) {
		boolean ok = false;
		projetoAtual.setDataHoraAtualizacao(new Date());
		ValidationResult result = business.validar(projetoAtual);
		if(result.isOk()){
			if (projetoAtual.getId() == null) {
				projetoAtual.setDataHoraCriacao(new Date());
				ok = repositorio.inserir(projetoAtual);
			} else {
				ok = repositorio.atualizar(projetoAtual);
			}
			if(!ok){
				result.addErrorMessage("persistencia", "Não foi possível salvar os dados do projeto");
			}
		}
		
		
		return result;
	}

	public boolean removerProjeto(Projeto projetoAtual) {
		boolean ok = false;
		int id = projetoAtual.getId();
		ok = repositorio.remover(id);
		return ok;
	}

}