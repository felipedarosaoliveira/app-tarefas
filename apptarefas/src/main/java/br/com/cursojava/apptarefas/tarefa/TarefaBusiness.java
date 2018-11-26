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
			result.addErrorMessage("nome", "O campo Nome é Obrigatório!");
		}else if(nome.length() <= 3) {
			result.addErrorMessage("nome", "O campo Nome deve possuir, no mínimo, 3 caracteres!");
		}
		if(descricao == null || "".equals(descricao.trim())) {
			result.addErrorMessage("descricao", "O campo Descricao é Obrigatório!");
		}else if(descricao.length() < 20) {
			result.addErrorMessage("descricao", "O campo Descrição deve possuir, no mínimo, 20 caracteres!");
		}
		try {
		if(situacao == null || "".equals(situacao.getNome().trim())) {
			result.addErrorMessage("situacao", "O campo Situação é obrigatório");
		}else if(situacao.getNome().length() < 3) {
			result.addErrorMessage("situacao", "O campo Situação deve possuir, no mínimo, 3 caracteres!");
		}
		}catch(NullPointerException e) {
			result.addErrorMessage("situacao", "O campo Situação é obrigatório");
		}
		return result;
	}

}
