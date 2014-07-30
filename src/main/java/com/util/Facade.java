package com.util;

import java.util.List;

public interface Facade<E> {
	
	void cadastrar(E entidade);

	void alterar(E entidade);

	void excluir(E entidade);

	E consultarPorId(E entidade);
	
	E consultarPorId(Integer id);
	
	List<E> consultarTodos(E entidade);
	
}
