package com.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.HorarioNoite;
import com.interfaces.IHorarioNoiteDAO;
import com.interfaces.IHorarioNoiteService;
import com.sun.faces.util.MessageFactory;
@Service
@Transactional
public class HorarioNoiteService implements IHorarioNoiteService{


    @Autowired
    private IHorarioNoiteDAO horarioNoiteDAO;
	
	@Override
	public List<HorarioNoite> listaHorario(HorarioNoite entidade) {
		return horarioNoiteDAO.listaHorarios(entidade);
		
	}

	@Override
	public void salvar(HorarioNoite entidade) {
		if(entidade.getIdHorarioNoite() != null){
			horarioNoiteDAO.atualizar(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização Realizada", ""));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Sample info message", MessageFactory.getMessage("Nao_foi_possivel_executar_esta_operacao._Se_o_erro_persistir_entre_em_contato_com_o_administrador_do_sistema",""));
		}
	}
}
