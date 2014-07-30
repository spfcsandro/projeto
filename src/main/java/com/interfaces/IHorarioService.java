package com.interfaces;

import java.util.List;

import com.entity.Horario;

public interface IHorarioService{
	 List<Horario> listaHorario(Horario entidade);
	 void salvar(Horario entidade);
}
