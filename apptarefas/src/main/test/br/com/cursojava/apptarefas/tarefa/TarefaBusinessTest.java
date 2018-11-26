package br.com.cursojava.apptarefas.tarefa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cursojava.apptarefas.situacao.Situacao;
import br.com.cursojava.apptarefas.utils.ValidationResult;

public class TarefaBusinessTest {

	TarefaBusiness business;
	Tarefa tar;
	@Before
	public void antesDeCadaTest() {
		business = new TarefaBusiness();
		 tar = new Tarefa();
	}
	
	@After
	public void depoisDeCadaTest() {
		System.out.println("Teste realizado");
	}
	
	@Test
	public void testNomeUm() {
		tar.setNome("Na");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("nome"), "O campo Nome deve possuir, no m�nimo, 3 caracteres!");
	}
	
	@Test
	public void testNomeDois() {
		tar.setNome("Tarefa Facade");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("nome"), null);
	}
	
	@Test
	public void testNomeTres() {
		tar.setNome(null);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("nome"), "O campo Nome � Obrigat�rio!");
	}
	
	@Test
	public void testNomeQuatro() {
		tar.setNome("");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("nome"), "O campo Nome � Obrigat�rio!");
	}
	
	@Test
	public void testNomeCinco() {
		tar.setNome("    ");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("nome"), "O campo Nome � Obrigat�rio!");
	}
	
	@Test
	public void testDescricaoUm() {
		tar.setDescricao("");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), "O campo Descricao � Obrigat�rio!");
	}
	
	@Test
	public void testDescricaoDois() {
		tar.setDescricao("    ");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), "O campo Descricao � Obrigat�rio!");
	}
	
	@Test
	public void testDescricaoTres() {
		tar.setDescricao("Descri��o menos 20");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), "O campo Descri��o deve possuir, no m�nimo, 20 caracteres!");
	}
	
	@Test
	public void testDescricaoQuatro() {
		tar.setDescricao(null);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), "O campo Descricao � Obrigat�rio!");
	}
	
	@Test
	public void testDescricaoCinco() {
		tar.setDescricao("Descri��o para tarefa com mais de 20 caracteres teste!");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), null);
	}
	
	@Test
	public void testSituacaoUm() {
		Situacao sit = new Situacao();
		sit.setNome(null);
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), "O campo Situa��o � obrigat�rio");
	}
	
	@Test
	public void testSituacaoDois() {
		Situacao sit = new Situacao();
		sit.setNome("");
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), "O campo Situa��o � obrigat�rio");
	}
	
	@Test
	public void testSituacaoTres() {
		Situacao sit = new Situacao();
		sit.setNome("    ");
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), "O campo Situa��o � obrigat�rio");
	}
	
	@Test
	public void testSituacaoQuatro() {
		Situacao sit = new Situacao();
		sit.setNome("Na");
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), "O campo Situa��o deve possuir, no m�nimo, 3 caracteres!");
	}
	
	@Test
	public void testSituacaoCinco() {
		Situacao sit = new Situacao();
		sit.setNome("Situa��o");
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), null);
	}
}
