package com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.dao.HorarioDAO;
import com.entity.Horario;
import com.service.HorarioService;

@Controller
@Component
@Scope("view")
public class HorarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Horario horario;
	@Autowired
	private HorarioService horarioService;
	private List<Horario> listaHorario;
	private Horario horarioSelecionada;


	@Autowired
	private HorarioDAO horarioDAO;


	@PostConstruct
	private void init() {
		horario = new Horario();
		this.listaHorario = horarioDAO.listaHorarios(horario);
	}
	
	public void onCellEdit(CellEditEvent event) {
		
		Object oldValue = event.getOldValue(); 
		Object newValue = event.getNewValue();  
        
        if(newValue != null && !newValue.equals(oldValue)) {  
        		horarioService.salvar(horario);
        }
	}
	
	public void onRowSelect(SelectEvent event) {
		Horario object = ((Horario) event.getObject());
		if(object != null){
			this.horario = object; 
		}
	}
	
	public List<Horario> getListaHorario() {
		return listaHorario;
	}
	
	
	public void setListaHorario(List<Horario> listaHorario) {
		this.listaHorario = listaHorario;
	}
	
	public Horario getHorario() {
		return horario;
	}


	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	

	public Horario getHorarioSelecionada() {
		return horarioSelecionada;
	}

	public void setHorarioSelecionada(Horario horarioSelecionada) {
		this.horarioSelecionada = horarioSelecionada;
	}
}
