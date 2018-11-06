package br.com.cursojava.apptarefas.usuario;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cursojava.apptarefas.utils.CrudRepository;
import br.com.cursojava.apptarefas.utils.JPAUtil;


public class UsuarioRepositorio implements CrudRepository<Usuario>{


	public boolean inserir(Usuario usuario) {
		boolean resultado = false;
		if (usuario != null &&  usuario.getId() == null) {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
			resultado =  usuario.getId() != null;
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
	public boolean remover(Usuario t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contar() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
