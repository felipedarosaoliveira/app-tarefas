package br.com.cursojava.situacao;

import br.com.apptarefadao.situacao.Situacao;
<<<<<<< HEAD:apptarefas/src/main/java/br/com/cursojava/apptarefas/situacao/SituacaoBusiness.java
import br.com.cursojava.apptarefasfacade.utils.ValidationResult;
=======
import br.com.cursojava.utils.ValidationResult;
>>>>>>> f08cdc3d34af9118c8d24617e38c6f91be9206de:app-tarefas-business/src/main/java/br/com/cursojava/situacao/SituacaoBusiness.java

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
