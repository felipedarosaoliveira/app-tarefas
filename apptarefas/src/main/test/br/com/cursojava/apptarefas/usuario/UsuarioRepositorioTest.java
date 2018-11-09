package br.com.cursojava.apptarefas.usuario;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioRepositorioTest {

	UsuarioRepositorio dao;

	@Before
	public void antesDeCadaTest() {
		dao = new UsuarioRepositorio();
		dao.inserir(new Usuario(null, "Usuario01", "user01@teste.com", "senha000", new Date(), new Date(),
				StatusUsuario.ATIVO));
		dao.inserir(new Usuario(null, "Usuario02", "user02@teste.com", "senha000", new Date(), new Date(),
				StatusUsuario.ATIVO));
		dao.inserir(new Usuario(null, "Usuario03", "user03@teste.com", "senha000", new Date(), new Date(),
				StatusUsuario.INATIVO));
	}

	@Test
	public void contarUsuarios() {
	
		Assert.assertEquals(dao.contar(), 3);
	}

	@Test
	public void buscarPorId() {
		Assert.assertEquals(dao.buscarPorId(3).getNome(), "Usuario03");
	}
	
	@Test
	public void buscarTodos() {
		Assert.assertEquals(dao.buscarTodos().size(), 3);		
	}
	
	@Test
	public void remover() {
		dao.remover(12);
		Assert.assertEquals(dao.buscarTodos().size(), 3);		
	}
	@Test
	public void atualizar() {
		
		Usuario user = dao.buscarPorId(3);
		user.setNome("Maria");
		dao.atualizar(user);
		Assert.assertEquals(dao.buscarPorId(3).getNome(), "Maria");
	}
	

}
