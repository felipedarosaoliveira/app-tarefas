package br.com.cursojava.apptarefas.utils;

import java.util.List;

public interface CrudRepository<T> {
	
	public boolean inserir(Class<T> classe);
	public boolean atualizar(T t);
	public boolean remover(T t);
	public List<T> buscarTodos();
	public T buscarPorId(int id);
	public long contar();

}
