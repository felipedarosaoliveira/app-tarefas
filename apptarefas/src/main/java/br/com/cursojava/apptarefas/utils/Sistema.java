package br.com.cursojava.apptarefas.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cursojava.apptarefas.situacao.Situacao;
import br.com.cursojava.apptarefas.situacao.SituacaoRepositorio;

public class Sistema {
	// retorna um Objeto lista dos registros solicitados
	public static Map<String, Situacao> getSituacoesPadrao(){
		List<String> nomes = Arrays.asList("Backlog","Priorizada","Em desenvolvimento","Finalizada");
		Map<String,Situacao> map = new HashMap<>();
	
			SituacaoRepositorio repositorio = new SituacaoRepositorio();
			Map<String,Situacao> dados = repositorio.buscarTodos()
			.stream()
			.filter(s ->{
				return nomes.contains(s.getNome());
			})
			.reduce(map,(result,current)->{
				result.put(current.getNome(),current);
				return result;
			}, (i,h)-> i);
			return dados;
			
			
		
	}
	
	

}
