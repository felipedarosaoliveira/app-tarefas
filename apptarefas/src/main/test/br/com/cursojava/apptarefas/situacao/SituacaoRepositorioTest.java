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
		long quantidadeAntes = sitrepos.contar();
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
	}
	
	@Test
	public void testeAtualizar(){
		sitrepos.inserir(new Situacao(null, "Priorizada", TipoSituacao.CLIENTE, new Date(), new Date(), new Date(), StatusSituacao.ATIVA));
		Situacao situacao = sitrepos.buscarPorId(1);
		situacao.setNome("Finalizada");
		sitrepos.atualizar(situacao);
		Assert.assertEquals(sitrepos.buscarPorId(1).getNome(), "Finalizada");
	}
	
	@Test
	public void testeRemover(){
		sitrepos.inserir(new Situacao(null, "Priorizada", TipoSituacao.CLIENTE, new Date(), new Date(), new Date(), StatusSituacao.ATIVA));
		sitrepos.inserir(new Situacao(null, "Finalizada", TipoSituacao.SISTEMA, new Date(), new Date(), new Date(), StatusSituacao.INATIVA));
		sitrepos.remover(1);
		Assert.assertEquals(sitrepos.buscarTodos().size(), 1);
	}
	
	@Test
	public void testeContarTodos(){
		sitrepos.inserir(new Situacao(null, "Priorizada", TipoSituacao.CLIENTE, new Date(), new Date(), new Date(), StatusSituacao.ATIVA));
		sitrepos.inserir(new Situacao(null, "Finalizada", TipoSituacao.SISTEMA, new Date(), new Date(), new Date(), StatusSituacao.INATIVA));
		Assert.assertEquals(sitrepos.contar(), 2);
	}
	
	@Test
	public void testeBuscar(){
		sitrepos.inserir(new Situacao(null, "Priorizada", TipoSituacao.CLIENTE, new Date(), new Date(), new Date(), StatusSituacao.ATIVA));
		sitrepos.inserir(new Situacao(null, "Finalizada", TipoSituacao.SISTEMA, new Date(), new Date(), new Date(), StatusSituacao.INATIVA));
		Assert.assertEquals(sitrepos.buscarPorId(1).getNome(), "Priorizada");
	}
	

	
	
}
