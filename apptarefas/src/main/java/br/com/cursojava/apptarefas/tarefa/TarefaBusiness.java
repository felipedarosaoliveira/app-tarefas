package br.com.cursojava.apptarefas.tarefa;

import br.com.cursojava.apptarefas.situacao.Situacao;
import br.com.cursojava.apptarefas.utils.ValidationResult;

public class TarefaBusiness {
	

	public ValidationResult validar(Tarefa tarefa) {
		ValidationResult result = new ValidationResult();
		
		String nome = tarefa.getNome();
		String descricao = tarefa.getDescricao();
		Situacao situacao = tarefa.getSituacao();
		if(nome == null || "".equals(nome.trim())) {
			result.addErrorMessage("nome", "O campo Nome � Obrigat�rio!");
		}else if(nome.length() <= 3) {
			result.addErrorMessage("nome", "O campo Nome deve possuir, no m�nimo, 3 caracteres!");
		}
		if(descricao == null || "".equals(descricao.trim())) {
			result.addErrorMessage("descricao", "O campo Descricao � Obrigat�rio!");
		}else if(descricao.length() < 20) {
			result.addErrorMessage("descricao", "O campo Descri��o deve possuir, no m�nimo, 20 caracteres!");
		}
		try {
		if(situacao == null || "".equals(situacao.getNome().trim())) {
			result.addErrorMessage("situacao", "O campo Situa��o � obrigat�rio");
		}else if(situacao.getNome().length() < 3) {
			result.addErrorMessage("situacao", "O campo Situa��o deve possuir, no m�nimo, 3 caracteres!");
		}
		}catch(NullPointerException e) {
			result.addErrorMessage("situacao", "O campo Situa��o � obrigat�rio");
		}
		return result;
	}

}
