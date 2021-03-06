package com.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.controller.UserSession;

public class ProjetoMockStant  implements UserDetails {
	private static final long serialVersionUID = 1L;

	private UserSession usuario;
	private String login;
	private String senha;
	private Collection<GrantedAuthority> authorities;

	public ProjetoMockStant(UserSession usuario, String login, String senha, 
			Collection<GrantedAuthority> authorities) {
		this.usuario = usuario;
		this.login = login;
		this.authorities = authorities;
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public UserSession getUsuario() {
		return usuario;
	}
}
