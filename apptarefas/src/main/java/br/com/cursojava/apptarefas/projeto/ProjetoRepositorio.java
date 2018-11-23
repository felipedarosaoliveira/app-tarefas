package br.com.cursojava.apptarefas.projeto;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.cursojava.apptarefas.utils.CrudRepository;
import br.com.cursojava.apptarefas.utils.JPAUtil;

public class ProjetoRepositorio implements CrudRepository<Projeto> {
	
	@Override
	public boolean inserir(Projeto projeto) {
		boolean resultado = false;
		if (projeto != null && projeto.getId() == null){
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(projeto);
			em.getTransaction().commit();
			em.close();
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean atualizar(Projeto projeto) {
		boolean resultado = false;
		if (projeto != null && projeto.getId() != null){
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.find(Projeto.class, projeto.getId());
			em.merge(projeto);
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
			Projeto projeto = em.find(Projeto.class, id);
			projeto.setStatus(ProjetoStatus.INATIVO);
			projeto.setDataHoraAtualizacao(new Date());
			projeto.setDataHoraFim(new Date());
			em.merge(projeto);
			resultado = true;
			em.getTransaction().commit();
			em.close();
		}
		return resultado;
	}

	@Override
	public List<Projeto> buscarTodos() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Projeto> query = cb.createQuery(Projeto.class);
		Root<Projeto> root = query.from(Projeto.class);
		query.select(root);
		query.where(cb.isNull(root.get("DataHoraFim")));
		Query queryFinal = em.createQuery(query);
		List<Projeto> resultado = queryFinal.getResultList();
		return resultado;
	}

	@Override
	public Projeto buscarPorId(int id) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Projeto> query = cb.createQuery(Projeto.class);
		Root<Projeto> root = query.from(Projeto.class);
		query.select(root);
		query.where(cb.equal(root.get("id"), id));
		Query queryFinal = em.createQuery(query);
		Projeto resultado = (Projeto)queryFinal.getSingleResult();
		return resultado;
	}

	@Override
	public long contar() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> queryCCount = cb.createQuery(Long.class);
		queryCCount.select(cb.count(queryCCount.from(Projeto.class)));
		Query queryCCountFinal = em.createQuery(queryCCount);
		Long resultado = (Long) queryCCountFinal.getSingleResult();
		return resultado;
	}



}

