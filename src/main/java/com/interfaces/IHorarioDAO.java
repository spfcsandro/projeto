package com.interfaces;

import java.util.List;

import com.entity.Horario;
import com.util.IDAO;

public interface IHorarioDAO  extends IDAO<Horario>{
	
	List<Horario> listaHorarios (Horario entidade);

}
