package br.com.apptarefadao.tarefa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.apptarefadao.projeto.Projeto;
import br.com.apptarefadao.util.CrudRepository;
import br.com.apptarefadao.util.JPAUtil;

public class TarefaRepositorio implements CrudRepository<Tarefa> {

	@Override
	public boolean inserir(Tarefa tarefas) {
		boolean resultado = false;
		if (tarefas != null && tarefas.getId() == null) {
			EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
			ent.getTransaction().begin();
			ent.persist(tarefas);
			ent.getTransaction().commit();
			ent.close();
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean atualizar(Tarefa tarefa) {
		boolean resultado = false;

		if (tarefa != null && tarefa.getId() != null) {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				em.merge(tarefa);
				em.getTransaction().commit();
				em.close();
				resultado = true;
			} catch (Exception e) {
				if (em != null && em.isOpen()) {
					em.getTransaction().rollback();
					em.close();
				}
			}
		}		
		return resultado;
	}

	@Override
	public boolean remover(int id) {
		boolean resultado = false;
		if (id >= 0) {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				Tarefa tarefa = em.find(Tarefa.class, id);
				tarefa.setDataHoraRemocao(new Date());
				em.merge(tarefa);
				em.getTransaction().commit();
				em.close();
				resultado = true;
			} catch (Exception e) {
				if (em != null && em.isOpen()) {
					em.getTransaction().rollback();
					em.close();
				}

			}
		}
		return resultado;
	}

	@Override
	public List<Tarefa> buscarTodos() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tarefa> cQuery = builder.createQuery(Tarefa.class);
		Root<Tarefa> tarefas = cQuery.from(Tarefa.class);
		cQuery.select(tarefas);
		cQuery.where(builder.isNull(tarefas.get("dataHoraRemocao")));
		TypedQuery<Tarefa> query = em.createQuery(cQuery);
		List<Tarefa> results = query.getResultList();
		em.close();
		return results;
	}

	@Override
	public Tarefa buscarPorId(int id) {
		if (id >= 0) {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Tarefa> cQuery = builder.createQuery(Tarefa.class);
			Root<Tarefa> tarefas = cQuery.from(Tarefa.class);
			cQuery.select(tarefas);
			cQuery.where(builder.and(builder.equal(tarefas.get("id"), id),builder.isNull(tarefas.get("dataHoraRemocao"))));
			TypedQuery<Tarefa> query = em.createQuery(cQuery);
			Tarefa result = query.getSingleResult();
			em.close();
			return result;
		} else {
			return null;
		}

	}

	@Override
	public long contar() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Long> cQuery = builder.createQuery(Long.class);
		Root<Tarefa> tarefas = cQuery.from(Tarefa.class);
		cQuery.multiselect(builder.count(tarefas),builder.isNull(tarefas.get("dataHoraRemocao")));
		TypedQuery<Long> query = em.createQuery(cQuery);
		Long results = query.getSingleResult();
		em.close();
		return results;
	}

	public List<Tarefa> buscarPorSituacao(String situacao) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tarefa> query = cb.createQuery(Tarefa.class);
		Root<Tarefa> root = query.from(Tarefa.class);
		query.select(root);
		query.where(cb.and(cb.equal(root.get("situacao"), situacao),cb.isNull(root.get("dataHoraRemocao"))));
		TypedQuery<Tarefa> queryFinal = em.createQuery(query);
		List<Tarefa> resultado = queryFinal.getResultList();
		em.close();
		return resultado;
	}

	public List<Tarefa> buscarPorProjeto(Projeto projetoAtual) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tarefa> cQuery = builder.createQuery(Tarefa.class);
		Root<Tarefa> tarefas = cQuery.from(Tarefa.class);
		cQuery.select(tarefas);
		cQuery.where(builder.and(builder.equal(tarefas.get("projeto"), projetoAtual),builder.isNull(tarefas.get("dataHoraRemocao"))));
		TypedQuery<Tarefa> query = em.createQuery(cQuery);
		List<Tarefa> resultado = query.getResultList();
		em.close();
		return resultado;
	}
}
