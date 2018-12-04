package br.com.cursojava;

import java.util.ArrayList;
import java.util.List;

public class RepositorioSituacao {
	
	
	private static List<Situacao> lista = new ArrayList<>();

	private static Integer count = 1;
	static{
		lista.add(new Situacao(count++, "sITUACAO 1"));
		lista.add(new Situacao(count++, "sITUACAO 2"));
		lista.add(new Situacao(count++, "sITUACAO 3"));
	}
}
