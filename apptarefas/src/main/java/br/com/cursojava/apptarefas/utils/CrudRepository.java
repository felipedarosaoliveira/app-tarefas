package br.com.cursojava.apptarefas.utils;

import java.util.List;

public interface CrudRepository<T> {
	
	public boolean inserir(T t);
	public boolean atualizar(T t);
	public boolean remover(int id);
	public List<T> buscarTodos();
	public T buscarPorId(int id);
	public long contar();

}
