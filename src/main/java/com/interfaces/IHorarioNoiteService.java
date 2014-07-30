package com.interfaces;

import java.util.List;

import com.entity.HorarioNoite;

public interface IHorarioNoiteService{
	 List<HorarioNoite> listaHorario(HorarioNoite entidade);
	 void salvar(HorarioNoite entidade);
}
