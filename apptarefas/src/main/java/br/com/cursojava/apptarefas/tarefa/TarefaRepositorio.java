package br.com.cursojava.apptarefas.tarefa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	public boolean atualizar(Tarefa tarefas) {
		boolean resultado = false;
		if (tarefas != null && tarefas.getId() != null) {
			EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
			ent.getTransaction().begin();
			ent.find(Tarefa.class, tarefas);
			ent.merge(tarefas);
			ent.getTransaction().commit();
			ent.close();
			resultado = true;
		}
		return resultado;

	}

	@Override
	public boolean remover(int id) {
		boolean resultado = false;
		if (id != 0) {
			EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
			ent.getTransaction().begin();
			Tarefa tarefas = ent.find(Tarefa.class, id);
			ent.remove(tarefas);
			ent.getTransaction().commit();
			ent.close();
			resultado = true;
		}
		return resultado;
	}

	@Override
	public List<Tarefa> buscarTodos() {
		EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
		ent.getTransaction().begin();
		CriteriaBuilder cri = ent.getCriteriaBuilder();
		CriteriaQuery<Tarefa> query = cri.createQuery(Tarefa.class);
		Root<Tarefa> root = query.from(Tarefa.class);
		query.select(root);
		TypedQuery<Tarefa> queryFinal = ent.createQuery(query);
		List<Tarefa> resultado = queryFinal.getResultList();
		return resultado;

	}

	@Override
	public Tarefa buscarPorId(int id) {
		EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
		ent.getTransaction().begin();
		CriteriaBuilder cb = ent.getCriteriaBuilder();
		CriteriaQuery<Tarefa> query = cb.createQuery(Tarefa.class);
		Root<Tarefa> root = query.from(Tarefa.class);
		query.select(root);
		query.where(cb.equal(root.get("id"), id));
		Query queryFinal = ent.createQuery(query);
		Tarefa resultado = (Tarefa) queryFinal.getSingleResult();
		return resultado;

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

	@Override
	public long contar() {

		EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder cb = ent.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<Tarefa> root = query.from(Tarefa.class);
		query.multiselect(cb.count(root));
		TypedQuery<Long> query2 = ent.createQuery(query);
		Long resultado = query2.getSingleResult();

		return resultado;

	}
}
