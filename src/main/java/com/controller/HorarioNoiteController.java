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

import com.dao.HorarioNoiteDAO;
import com.entity.HorarioNoite;
import com.service.HorarioNoiteService;

@Controller
@Component
@Scope("view")
public class HorarioNoiteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private HorarioNoite horarioNoite;
	@Autowired
	private HorarioNoiteService horarioNoiteService;
	private List<HorarioNoite> listaHorario;
	private HorarioNoite horarioSelecionada;


	@Autowired
	private HorarioNoiteDAO horarioNoiteDAO;


	@PostConstruct
	private void init() {
		horarioNoite = new HorarioNoite();
		this.listaHorario = horarioNoiteDAO.listaHorarios(horarioNoite);
	}
	
	public void onCellEdit(CellEditEvent event) {

		Object oldValue = event.getOldValue(); 
		Object newValue = event.getNewValue();  
        
        if(newValue != null && !newValue.equals(oldValue)) {  
        	horarioNoiteService.salvar(horarioNoite);
        }
	}
	
	public void onRowSelect(SelectEvent event) {
		HorarioNoite object = ((HorarioNoite) event.getObject());
		if(object != null){
			this.horarioNoite = object; 
			
		}
	}
	
	public List<HorarioNoite> getListaHorario() {
		return listaHorario;
	}
	
	
	public void setListaHorario(List<HorarioNoite> listaHorario) {
		this.listaHorario = listaHorario;
	}
	
	public HorarioNoite getHorario() {
		return horarioNoite;
	}


	public void setHorarioNoite(HorarioNoite horarioNoite) {
		this.horarioNoite = horarioNoite;
	}
	

	public HorarioNoite getHorarioSelecionada() {
		return horarioSelecionada;
	}

	public void setHorarioSelecionada(HorarioNoite horarioSelecionada) {
		this.horarioSelecionada = horarioSelecionada;
	}
}
