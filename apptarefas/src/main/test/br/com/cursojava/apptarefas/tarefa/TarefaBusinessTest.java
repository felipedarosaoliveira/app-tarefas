package br.com.cursojava.apptarefas.tarefa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.apptarefadao.situacao.Situacao;
import br.com.apptarefadao.tarefa.Tarefa;
import br.com.cursojava.utils.ValidationResult;
import br.com.cursojava.tarefa.TarefaBusiness;

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
		Assert.assertEquals(result.getMessages().get("nome"), "O campo Nome deve possuir, no mínimo, 3 caracteres!");
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
		Assert.assertEquals(result.getMessages().get("nome"), "O campo Nome é Obrigatório!");
	}
	
	@Test
	public void testNomeQuatro() {
		tar.setNome("");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("nome"), "O campo Nome é Obrigatório!");
	}
	
	@Test
	public void testNomeCinco() {
		tar.setNome("    ");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("nome"), "O campo Nome é Obrigatório!");
	}
	
	@Test
	public void testDescricaoUm() {
		tar.setDescricao("");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), "O campo Descricao é Obrigatório!");
	}
	
	@Test
	public void testDescricaoDois() {
		tar.setDescricao("    ");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), "O campo Descricao é Obrigatório!");
	}
	
	@Test
	public void testDescricaoTres() {
		tar.setDescricao("Descrição menos 20");
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), "O campo Descrição deve possuir, no mínimo, 20 caracteres!");
	}
	
	@Test
	public void testDescricaoQuatro() {
		tar.setDescricao(null);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("descricao"), "O campo Descricao é Obrigatório!");
	}
	
	@Test
	public void testDescricaoCinco() {
		tar.setDescricao("Descrição para tarefa com mais de 20 caracteres teste!");
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
		Assert.assertEquals(result.getMessages().get("situacao"), "O campo Situação é obrigatório");
	}
	
	@Test
	public void testSituacaoDois() {
		Situacao sit = new Situacao();
		sit.setNome("");
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), "O campo Situação é obrigatório");
	}
	
	@Test
	public void testSituacaoTres() {
		Situacao sit = new Situacao();
		sit.setNome("    ");
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), "O campo Situação é obrigatório");
	}
	
	@Test
	public void testSituacaoQuatro() {
		Situacao sit = new Situacao();
		sit.setNome("Na");
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), "O campo Situação deve possuir, no mínimo, 3 caracteres!");
	}
	
	@Test
	public void testSituacaoCinco() {
		Situacao sit = new Situacao();
		sit.setNome("Situação");
		tar.setSituacao(sit);
		ValidationResult result = business.validar(tar);
		Assert.assertFalse(result.isOk());
		Assert.assertEquals(result.getMessages().get("situacao"), null);
	}
}
