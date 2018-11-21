package br.com.cursojava.apptarefas.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	
	public static String gerarHash(String valor){
		try{
		 MessageDigest digest = MessageDigest.getInstance("MD5");
		 byte[] valorMD5 = digest.digest(valor.getBytes("UTF-8"));
         
        
         StringBuffer sb = new StringBuffer();
         for (byte b : valorMD5){
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
         }

         return sb.toString();
		}catch(Exception e){
			throw new IllegalArgumentException("Não foi possível converter o texto");
		}
	}
	
	
	
	
	

}
