package com.util;

import java.util.Collection;

public interface IDAO<E> {

	void salvar(E entidade);
	E atualizar(E entidade);
	E atualizar(E entidade, boolean validaDataBloqueio);
	void excluir(E entidade);
	void excluirLista(Collection<E> entities);
	void flush();
	void clear();
	void refresh(E entidade);
	void salvaOuAtualizaCollection(Collection<E> lista);
	void salvarLista(Collection<E> lista);
	void atualizarLista(Collection<E> lista);
	
	E find(Object id);
}
