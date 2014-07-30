package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.Pessoa;
import com.interfaces.IPessoaDAO;
import com.util.AbastractDAO;

@Repository
@SuppressWarnings("unchecked")
public class PessoaDAO extends AbastractDAO<Pessoa> implements IPessoaDAO{

	@PersistenceContext EntityManager entityManager;

	@Override
	public List<Pessoa> listaPessoas(Pessoa entidade) {
		List<Pessoa> lista = getEntityManager().createQuery("select p from Pessoa p ")
					.getResultList();	
			return lista;
	}
	
}
