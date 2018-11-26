package br.com.cursojava.apptarefas.usuario;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.cursojava.apptarefas.utils.CrudRepository;
import br.com.cursojava.apptarefas.utils.JPAUtil;

public class UsuarioRepositorio implements CrudRepository<Usuario> {

	public boolean inserir(Usuario usuario) {
		boolean resultado = false;
		if (usuario != null && usuario.getId() == null) {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
			resultado = usuario.getId() != null;
		}
		return resultado;
	}

	@Override
	public boolean atualizar(Usuario usuario) {
		boolean resultado = false;

		if (usuario != null && usuario.getId() != null) {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				em.merge(usuario);
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
	public List<Usuario> buscarTodos() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> cQuery = builder.createQuery(Usuario.class);
		Root<Usuario> usuarios = cQuery.from(Usuario.class);
		cQuery.select(usuarios);
		// criar o filtro para verificar se dataremoção nao for nulo
		TypedQuery<Usuario> query = em.createQuery(cQuery);
		List<Usuario> results = query.getResultList();
		return results;
	}

	@Override
	public Usuario buscarPorId(int id) {
		if (id >= 0) {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Usuario> cQuery = builder.createQuery(Usuario.class);
			Root<Usuario> usuarios = cQuery.from(Usuario.class);
			cQuery.select(usuarios);
			
			cQuery.where (builder.and(builder.equal(usuarios.get("id"), id), builder.isNull(usuarios.get("dataHoraRemocao"))));
			TypedQuery<Usuario> query = em.createQuery(cQuery);
			Usuario result = query.getSingleResult();
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
		Root<Usuario> usuarios = cQuery.from(Usuario.class);
		cQuery.multiselect(builder.count(usuarios));
		TypedQuery<Long> query = em.createQuery(cQuery);
		Long results = query.getSingleResult();
		return results;
	}

	@Override
	public boolean remover(int id) {
		boolean resultado = false;
		if (id >= 0) {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				Usuario usuario = em.find(Usuario.class, id);
				usuario.setStatus(StatusUsuario.INATIVO);
				usuario.setDataHoraAtualizacao(new Date());
				usuario.setDataHoraRemocao(new Date());
				em.merge(usuario);
				resultado = true;
				em.getTransaction().commit();
				em.close();
				
			} catch (Exception e) {
				if (em != null && em.isOpen()) {
					em.getTransaction().rollback();
				}

			}
		}
		return resultado;
	}


	public Usuario buscarPorEmail(String email) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> cQuery = builder.createQuery(Usuario.class);
		Root<Usuario> usuarios = cQuery.from(Usuario.class);
		cQuery.select(usuarios);
		cQuery.where(builder.equal(usuarios.get("email"), email));
		TypedQuery<Usuario> query = em.createQuery(cQuery);
		Usuario result = null;
		try {
			result = query.getSingleResult();
		}catch(Exception e) {
			result = null;
		}
		return result;
	}
}