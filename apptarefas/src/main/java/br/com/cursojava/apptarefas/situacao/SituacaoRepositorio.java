package br.com.cursojava.apptarefas.situacao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cursojava.apptarefas.utils.CrudRepository;
import br.com.cursojava.apptarefas.utils.JPAUtil;

public class SituacaoRepositorio implements CrudRepository<Situacao> {

	@Override
	public boolean inserir(Situacao situacao) {
		boolean resultado = false;
		if (situacao != null){
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(situacao);
			em.getTransaction().commit();
			em.close();
			JPAUtil.shutdown();
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean atualizar(Situacao t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(Situacao t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Situacao> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Situacao buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contar() {
		// TODO Auto-generated method stub
		return 0;
	}



}
