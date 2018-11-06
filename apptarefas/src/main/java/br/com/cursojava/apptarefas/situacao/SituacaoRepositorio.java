package br.com.cursojava.apptarefas.situacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.cursojava.apptarefas.utils.CrudRepository;
import br.com.cursojava.apptarefas.utils.JPAUtil;

public class SituacaoRepositorio implements CrudRepository<Situacao> {

	@Override
	public boolean inserir(Situacao situacao) {
		boolean resultado = false;
		if (situacao != null && situacao.getId() == null){
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
	public boolean atualizar(Situacao situacao) {
		boolean resultado = false;
		if (situacao != null && situacao.getId() != null){
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.find(Situacao.class, situacao);
			em.merge(situacao);
			em.getTransaction().commit();
			em.close();
			JPAUtil.shutdown();
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean remover(int id) {
		boolean resultado = false;
//		if (id != 0){
//			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
//			em.getTransaction().begin();
//			em.find(Situacao.class, id);
//			em.remove();
//			em.getTransaction().commit();
//			em.close();
//			JPAUtil.shutdown();
//			resultado = true;
//		}
		return resultado;
	}

	@Override
	public List<Situacao> buscarTodos() {
//		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
//		em.getTransaction().begin();
//		CriteriaBuilder cb = 
//		CriteriaQuery<Situacao> query = 
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
