package com.interfaces;

import java.util.List;

import com.entity.HorarioTarde;
import com.util.IDAO;

public interface IHorarioTardeDAO extends IDAO<HorarioTarde>{
	
	List<HorarioTarde> listaHorarios (HorarioTarde entidade);

}
