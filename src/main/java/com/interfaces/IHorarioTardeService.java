package com.interfaces;

import java.util.List;

import com.entity.HorarioTarde;

public interface IHorarioTardeService{
	 List<HorarioTarde> listaHorario(HorarioTarde entidade);
	 void salvar(HorarioTarde entidade);
}
