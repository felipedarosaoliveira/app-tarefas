
package br.com.cursojava.projeto;

import br.com.apptarefadao.projeto.Projeto;
<<<<<<< HEAD:apptarefas/src/main/java/br/com/cursojava/apptarefas/projeto/ProjetoBusiness.java
import br.com.cursojava.apptarefasfacade.utils.ValidationResult;
=======
import br.com.cursojava.utils.ValidationResult;
>>>>>>> f08cdc3d34af9118c8d24617e38c6f91be9206de:app-tarefas-business/src/main/java/br/com/cursojava/projeto/ProjetoBusiness.java

public class ProjetoBusiness {
	
	public ValidationResult validar(Projeto projeto){
		ValidationResult resultado = new ValidationResult();
		
		String nome = projeto.getNome();
		if(nome == null || "".equals(nome.trim())){
			resultado.addErrorMessage("nome", "O campo nome � Obrigat�rio");
		}else if(nome.length() < 3){
			resultado.addErrorMessage("nome", "O campo nome deve possuir ao menos 3 caracteres");
		}
		return resultado;
	}
}

