package br.com.cursojava.apptarefas.situacao;

import java.util.List;

import br.com.cursojava.apptarefas.projeto.Projeto;
import br.com.cursojava.apptarefas.utils.CrudRepository;

public class SituacaoRepositorio implements CrudRepository<Projeto> {

	@Override
	public boolean inserir(Class<Projeto> classe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Projeto t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(Projeto t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Projeto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long contar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Projeto buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
