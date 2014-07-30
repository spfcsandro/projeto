package com.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Horario;
import com.interfaces.IHorarioDAO;
import com.interfaces.IHorarioService;
import com.sun.faces.util.MessageFactory;
@Service
@Transactional
public class HorarioService implements IHorarioService{


    @Autowired
    private IHorarioDAO horarioDAO;
	
	@Override
	public List<Horario> listaHorario(Horario entidade) {
		return horarioDAO.listaHorarios(entidade);
		
	}

	@Override
	public void salvar(Horario entidade) {
		if(entidade.getIdHorario() != null){
			horarioDAO.atualizar(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro Realizado", ""));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Sample info message", MessageFactory.getMessage("Nao_foi_possivel_executar_esta_operacao._Se_o_erro_persistir_entre_em_contato_com_o_administrador_do_sistema",""));
		}
	}
}
