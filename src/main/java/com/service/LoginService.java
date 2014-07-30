package com.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.interfaces.ILoginService;
import com.interfaces.IUserDAO;
import com.sun.faces.util.MessageFactory;

@Service
@Transactional
public class LoginService implements ILoginService {
	
    @Autowired
    private IUserDAO dao;
 
    @Override
    public User login(String username, String password)
            throws IllegalArgumentException {
        if (isEmptyOrNull(username) || isEmptyOrNull(password)) {
            throw new IllegalArgumentException(
                    "Atenção, usuário ou senhas vazios!");
        }
        User u = dao.login(username, password);
         
        if (u == null) {
            throw new IllegalArgumentException(
                    "Erro: usuário ou senhas incorretos!");
        }
        return u;
    }
 
    private boolean isEmptyOrNull(String s) {
        return s == null || s.equals("");
    }

	@Override
	public List<User> listaUsuario(User user) {
		return dao.listaUsuario(user);		
	}

	@Override
	public void deletar(User user) {
		if(user.getId() != null){
			this.dao.excluir(dao.find(user.getId()));
			}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Sample info message", MessageFactory.getMessage("Nao_foi_possivel_executar_esta_operacao._Se_o_erro_persistir_entre_em_contato_com_o_administrador_do_sistema","")); 
		}	
	}

	@Override
	public void salvar(User user) throws IllegalArgumentException {
		if(user.getId() == null){
			dao.salvar(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro Realizado", ""));
		}else if(user.getId() != null){
			dao.atualizar(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização Realizada", ""));
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Sample info message", MessageFactory.getMessage("Nao_foi_possivel_executar_esta_operacao._Se_o_erro_persistir_entre_em_contato_com_o_administrador_do_sistema","")); 
		}
	}
	
	
}