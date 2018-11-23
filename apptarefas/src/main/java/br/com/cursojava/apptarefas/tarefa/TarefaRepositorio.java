package br.com.cursojava.apptarefas.tarefa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.cursojava.apptarefas.projeto.Projeto;
import br.com.cursojava.apptarefas.usuario.Usuario;
import br.com.cursojava.apptarefas.utils.CrudRepository;
import br.com.cursojava.apptarefas.utils.JPAUtil;

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
				em.remove(em.find(Usuario.class, id));
				em.getTransaction().commit();
				em.close();
				resultado = true;
			} catch (Exception e) {
				if (em != null && em.isOpen()) {
					em.getTransaction().rollback();
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
		TypedQuery<Tarefa> query = em.createQuery(cQuery);
		List<Tarefa> results = query.getResultList();
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
			cQuery.where(builder.equal(tarefas.get("id"), id));
			TypedQuery<Tarefa> query = em.createQuery(cQuery);
			Tarefa result = query.getSingleResult();
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
		cQuery.multiselect(builder.count(tarefas));
		TypedQuery<Long> query = em.createQuery(cQuery);
		Long results = query.getSingleResult();
		return results;
	}

	public List<Tarefa> buscarPorSituacao(String situacao) {
		EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
		ent.getTransaction().begin();
		CriteriaBuilder cb = ent.getCriteriaBuilder();
		CriteriaQuery<Tarefa> query = cb.createQuery(Tarefa.class);
		Root<Tarefa> root = query.from(Tarefa.class);
		query.select(root);
		query.where(cb.equal(root.get("situacao"), situacao));
		TypedQuery<Tarefa> queryFinal = ent.createQuery(query);
		List<Tarefa> resultado = queryFinal.getResultList();

		return resultado;
	}

	public List<Tarefa> buscarPorProjeto(Projeto projetoAtual) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tarefa> cQuery = builder.createQuery(Tarefa.class);
		Root<Tarefa> tarefas = cQuery.from(Tarefa.class);
		cQuery.select(tarefas);
		cQuery.where(builder.equal(tarefas.get("projeto"), projetoAtual));
		TypedQuery<Tarefa> query = em.createQuery(cQuery);
		List<Tarefa> resultado = query.getResultList();

		return resultado;
	}
}
