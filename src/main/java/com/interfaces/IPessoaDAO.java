package com.interfaces;

import java.util.List;

import com.entity.Pessoa;
import com.util.IDAO;

public interface IPessoaDAO extends IDAO<Pessoa>{
	
	List<Pessoa> listaPessoas (Pessoa entidade);
}
