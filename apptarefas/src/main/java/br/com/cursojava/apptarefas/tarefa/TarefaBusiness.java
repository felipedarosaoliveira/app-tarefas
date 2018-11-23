package br.com.cursojava.apptarefas.tarefa;

import br.com.cursojava.apptarefas.situacao.Situacao;
import br.com.cursojava.apptarefas.utils.ValidationResult;

public class TarefaBusiness {
	
	public ValidationResult validar(Tarefa tarefa) {
		ValidationResult result = new ValidationResult();
		
		String nome = tarefa.getNome();
		if(nome != null || "".equals(nome.trim())) {
			result.addErrorMessage("nome", "O campo Nome é Obrigatório!");
		}
		String descricao = tarefa.getDescricao();
		if(descricao != null || "".equals(descricao.trim())) {
			result.addErrorMessage("descricao", " O campo Descricao é Obrigatório!");
		}
		Situacao situacao = tarefa.getSituacao();
		if(situacao != null || "".equals(situacao.getNome().trim())) {
			result.addErrorMessage("situacao", "O campo Situação é obrigatório");
		}
		
		return result;
	}

}
