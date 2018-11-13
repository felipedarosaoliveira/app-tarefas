package br.com.cursojava.apptarefas.situacao;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SituacaoRepositorioTest {
	
	private SituacaoRepositorio sitrepos;

	@Before
	public void antes(){
		sitrepos = new SituacaoRepositorio();
		sitrepos.inserir(new Situacao(null, "Priorizada", TipoSituacao.CLIENTE, new Date(), new Date(), new Date(), StatusSituacao.ATIVA));
		sitrepos.inserir(new Situacao(null, "Finalizada", TipoSituacao.SISTEMA, new Date(), new Date(), new Date(), StatusSituacao.INATIVA));
	}
	
	@After
	public void depois(){
		sitrepos.remover(1);
		sitrepos.remover(2);
	}
	
	@Test
	public void testeAdicionar() {
		boolean resultado = sitrepos.inserir(new Situacao(null, "EmAndamento", TipoSituacao.CLIENTE, new Date(), new Date(), new Date(), StatusSituacao.ATIVA));
		Assert.assertEquals(true, resultado);
		sitrepos.remover(3);
	}
	
	@Test
	public void testeAtualizar(){
		Situacao situacao = sitrepos.buscarPorId(1);
		situacao.setNome("EmAndamento");
		sitrepos.atualizar(situacao);
		Assert.assertEquals(sitrepos.buscarPorId(1).getNome(), "Finalizada");
	}
	
	@Test
	public void testeRemover(){
		sitrepos.remover(1);
		Assert.assertEquals(sitrepos.buscarTodos().size(), 1);
	}
	
	@Test
	public void testeContarTodos(){
		long quantidadeAntes = sitrepos.contar();
		Assert.assertEquals(quantidadeAntes, 2);
	}
	
	@Test
	public void testeBuscarPorId(){
		Assert.assertEquals(sitrepos.buscarPorId(1).getNome(), "Priorizada");
	}
	
	@Test
	public void testeBuscarTodos(){
		Assert.assertEquals(sitrepos.buscarTodos().size(), 2);
	}

	
	
}
