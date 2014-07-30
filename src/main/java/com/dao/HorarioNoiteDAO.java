package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.HorarioNoite;
import com.interfaces.IHorarioNoiteDAO;
import com.util.AbastractDAO;
@Repository
@SuppressWarnings("unchecked")
public class HorarioNoiteDAO extends AbastractDAO<HorarioNoite>implements IHorarioNoiteDAO {

	@PersistenceContext EntityManager entityManager;

	@Override
	public List<HorarioNoite> listaHorarios(HorarioNoite entidade) {
		List<HorarioNoite> lista = getEntityManager().createQuery("select p from HorarioNoite p ")
				.getResultList();	
		return lista;
	}

}
