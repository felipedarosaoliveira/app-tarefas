package br.com.apptarefas.situacao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cursojava.apptarefas.usuario.StatusUsuario;
import br.com.cursojava.apptarefas.usuario.Usuario;
import br.com.cursojava.apptarefas.usuario.UsuarioRepositorio;

public class UsuarioRepositorioTest {
	
	UsuarioRepositorio dao;

	@Before
	public void antesDeCadaTest() {
		dao = new UsuarioRepositorio();
	}
	
	@Test
	public void inserirUsuario() {
		UsuarioRepositorio dao = new UsuarioRepositorio();
		Usuario u1 = new Usuario(null, "Usuario01", "user01@teste.com", "senha000", new Date(), new Date(), StatusUsuario.ATIVO);
		Usuario u2 = new Usuario(null, "Usuario02", "user02@teste.com", "senha000", new Date(), new Date(), StatusUsuario.ATIVO);
		Usuario u3 = new Usuario(null, "Usuario03", "user03@teste.com", "senha000", new Date(), new Date(), StatusUsuario.INATIVO);
		dao.inserir(u1);
		dao.inserir(u2);
		dao.inserir(u3);
		Assert.assertEquals(dao.contar(), 3);
		
	}

}
