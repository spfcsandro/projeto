package com.interfaces;

import java.util.List;

import com.entity.Pessoa;

public interface IPessoaService {
	void salvar(Pessoa pessoa) throws IllegalArgumentException;
	List<Pessoa> listaPessoas(Pessoa pessoa);
	void deletar(Pessoa pessoa);
}
