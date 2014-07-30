package com.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.entity.User;
import com.service.LoginService;

@Controller
@Component
@Scope("session")
public class UserSession {

	private User user;
	@Autowired private LoginService loginService;
	private List<User> listaUsuario;
	private User usuarioSelecionado;


	@PostConstruct
	private void init() {
		user = new User();
		this.listaUsuario = loginService.listaUsuario(user);
		this.usuarioSelecionado = null;
	}

	public void novo(){
		init();
		RequestContext.getCurrentInstance().reset(":form:panel");  
	}
	
	public String index(){
		return "pages/successfulPage.xhtml?faces-redirect=true";
	}

	public void salvar() {
		loginService.salvar(user);
		novo();
	}

	public void deletar() {
		loginService.deletar(usuarioSelecionado);
		novo();
	}

	public void onRowSelect(SelectEvent event) {
		User object = ((User) event.getObject());
		if (object != null) {
			this.user = object;
		}
	}

	public void onRowUnselect(UnselectEvent event) {
		novo();
	}

	public List<User> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<User> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return user != null;
	}
	
	public User getUsuarioSelecionado() {
		return usuarioSelecionado;
	}
	
	public void setUsuarioSelecionado(User usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
}
