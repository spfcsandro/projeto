package com.interfaces;

import java.util.List;

import com.entity.HorarioNoite;
import com.util.IDAO;

public interface IHorarioNoiteDAO extends IDAO<HorarioNoite> {
	
	List<HorarioNoite> listaHorarios (HorarioNoite entidade);

}
