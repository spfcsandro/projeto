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

import com.dao.HorarioTardeDAO;
import com.entity.HorarioTarde;
import com.service.HorarioTardeService;

@Controller
@Component
@Scope("view")
public class HorarioTardeController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private HorarioTarde horarioTarde;
	@Autowired
	private HorarioTardeService horarioTardeService;
	private List<HorarioTarde> listaHorario;
	private HorarioTarde horarioSelecionada;


	@Autowired
	private HorarioTardeDAO horarioTardeDAO;


	@PostConstruct
	private void init() {
		horarioTarde = new HorarioTarde();
		this.listaHorario = horarioTardeDAO.listaHorarios(horarioTarde);
	}
	
	public void onCellEdit(CellEditEvent event) {

		Object oldValue = event.getOldValue(); 
		Object newValue = event.getNewValue();  
        
        if(newValue != null && !newValue.equals(oldValue)) {  
        	horarioTardeService.salvar(horarioTarde);
        }
	}
	
	public void onRowSelect(SelectEvent event) {
		HorarioTarde object = ((HorarioTarde) event.getObject());
		if(object != null){
			this.horarioTarde = object; 
			
		}
	}
	
	public List<HorarioTarde> getListaHorario() {
		return listaHorario;
	}
	
	
	public void setListaHorario(List<HorarioTarde> listaHorario) {
		this.listaHorario = listaHorario;
	}
	
	public HorarioTarde getHorario() {
		return horarioTarde;
	}


	public void setHorario(HorarioTarde horarioTarde) {
		this.horarioTarde = horarioTarde;
	}
	

	public HorarioTarde getHorarioSelecionada() {
		return horarioSelecionada;
	}

	public void setHorarioSelecionada(HorarioTarde horarioSelecionada) {
		this.horarioSelecionada = horarioSelecionada;
	}
}
