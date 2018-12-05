package br.com.cursojava.situacao;

import br.com.apptarefadao.situacao.Situacao;
import br.com.cursojava.utils.ValidationResult;

public class SituacaoBusiness {

	public ValidationResult validar(Situacao situacao){
		ValidationResult resultado = new ValidationResult();
		
		String nome = situacao.getNome();
		if(nome == null || "".equals(nome.trim())){
			resultado.addErrorMessage("nome", "O campo Nome é Obrigatório");
		} else if(nome.length() < 3){
			resultado.addErrorMessage("nome", "o Campo Nome deve possuir ao menos 3 caracteres!");
		}
		return resultado;
	}
	
}
