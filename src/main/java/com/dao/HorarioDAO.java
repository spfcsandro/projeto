package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.Horario;
import com.interfaces.IHorarioDAO;
import com.util.AbastractDAO;
@Repository
@SuppressWarnings("unchecked")
public class HorarioDAO extends AbastractDAO<Horario>implements IHorarioDAO {

	@PersistenceContext EntityManager entityManager;

	@Override
	public List<Horario> listaHorarios(Horario entidade) {
		List<Horario> lista = getEntityManager().createQuery("select p from Horario p ")
				.getResultList();	
		return lista;
	}

}
