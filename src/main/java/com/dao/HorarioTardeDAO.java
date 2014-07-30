package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.HorarioTarde;
import com.interfaces.IHorarioTardeDAO;
import com.util.AbastractDAO;
@Repository
@SuppressWarnings("unchecked")
public class HorarioTardeDAO extends AbastractDAO<HorarioTarde>implements IHorarioTardeDAO {

	@PersistenceContext EntityManager entityManager;

	@Override
	public List<HorarioTarde> listaHorarios(HorarioTarde entidade) {
		List<HorarioTarde> lista = getEntityManager().createQuery("select p from HorarioTarde p ")
				.getResultList();	
		return lista;
	}

}
