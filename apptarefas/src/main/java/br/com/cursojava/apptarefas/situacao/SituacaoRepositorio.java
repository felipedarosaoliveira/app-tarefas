package br.com.cursojava.apptarefas.situacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.cursojava.apptarefas.usuario.Usuario;
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
			em.merge(situacao);
			em.getTransaction().commit();
			em.close();
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean remover(int id) {
		boolean resultado = false;
		if (id != 0){
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			Situacao situacao = em.find(Situacao.class, id);
			em.remove(situacao);
			em.getTransaction().commit();
			em.close();
			resultado = true;
		}
		return resultado;
	}

	@Override
	public List<Situacao> buscarTodos() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Situacao> cQuery = builder.createQuery(Situacao.class);
		Root<Situacao> situacoes = cQuery.from(Situacao.class);
		cQuery.select(situacoes);
		TypedQuery<Situacao> query = em.createQuery(cQuery);
		List<Situacao> results = query.getResultList();
		return results;
	}

	@Override
	public Situacao buscarPorId(int id) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Situacao> query = cb.createQuery(Situacao.class);
		Root<Situacao> root = query.from(Situacao.class);
		query.select(root);
		query.where(cb.equal(root.get("id"), id));
		Query queryFinal = em.createQuery(query);
		Situacao resultado = (Situacao)queryFinal.getSingleResult();
		return resultado;
	}

	@Override
	public long contar() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> queryCCount = cb.createQuery(Long.class);
		queryCCount.select(cb.count(queryCCount.from(Situacao.class)));
		Query queryCCountFinal = em.createQuery(queryCCount);
		Long resultado = (Long) queryCCountFinal.getSingleResult();
		return resultado;
	}

}
