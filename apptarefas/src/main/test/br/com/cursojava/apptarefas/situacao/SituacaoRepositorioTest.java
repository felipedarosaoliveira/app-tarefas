package br.com.cursojava.apptarefas.situacao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SituacaoRepositorioTest {
	
	private SituacaoRepositorio sitrepos;

	@Before
	public void antes(){
		sitrepos = new SituacaoRepositorio();
	}
	
	@Test
	public void testeAdicionar() {
//		boolean resultado = sitrepos.inserir(new Situacao(null, "Em Teste", TipoSituacao.CLIENTE, new Date(), new Date(), null));
//		Assert.assertEquals(true, resultado);
		
	}
	
	
}
