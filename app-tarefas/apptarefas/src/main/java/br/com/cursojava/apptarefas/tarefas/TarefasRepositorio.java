package br.com.cursojava.apptarefas.tarefas;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.cursojava.apptarefas.utils.JPAUtil;

public class TarefasRepositorio {

	@Override
	public boolean salvar(Tarefas tarefas) {
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
	public boolean editar(Tarefas tarefas) {
		boolean resultado = false;
		if (tarefas != null && tarefas.getId() != null) {
			EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
			ent.getTransaction().begin();
			ent.find(TarefasRepositorio.class, tarefas);
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
			Tarefas tarefas = ent.find(Tarefas.class, id);
			ent.remove(tarefas);
			ent.getTransaction().commit();
			ent.close();
			resultado = true;
		}
		return resultado;
	}

	@Override
	public List<Tarefas> buscarTodos() {
		EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
		ent.getTransaction().begin();
		CriteriaBuilder cri = ent.getCriteriaBuilder();
		CriteriaQuery<Tarefas> query = cri.createQuery(Tarefas.class);
		Root<Tarefas> root = query.from(Tarefas.class);
		query.select(root);
		Query queryFinal = ent.createQuery(query);
		List<Tarefas> resultado = queryFinal.getResultList();
		return resultado;

	}

	@Override
	public Tarefas buscarPorId(int id) {
		EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
		ent.getTransaction().begin();
		CriteriaBuilder cb = ent.getCriteriaBuilder();
		CriteriaQuery<Tarefas> query = cb.createQuery(Tarefas.class);
		Root<Tarefas> root = query.from(Tarefas.class);
		query.select(root);
		query.where(cb.equal(root.get("id"), id));
		Query queryFinal = ent.createQuery(query);
		Tarefas resultado = (Tarefas) queryFinal.getSingleResult();
		return resultado;

	}

	@Override
	public List<Tarefas> buscarPorSituacao(String situacao) {
		EntityManager ent = JPAUtil.getEntityManagerFactory().createEntityManager();
		ent.getTransaction().begin();
		CriteriaBuilder cb = ent.getCriteriaBuilder();
		CriteriaQuery<Tarefas> query = cb.createQuery(Tarefas.class);
		Root<Tarefas> root = query.from(Tarefas.class);
		query.select(root);
		query.where(cb.equal(root.get("situacao"), situacao));
		Query queryFinal = ent.createQuery(query);
		List<Tarefas> resultado = queryFinal.getResultList();

		return resultado;
	}
}
