package com.interfaces;

import java.util.List;

import com.entity.User;

public interface ILoginService {
    User login(String username, String password) throws IllegalArgumentException;
    List<User> listaUsuario(User user);
	void deletar(User user);
	void salvar(User user) throws IllegalArgumentException;
    
}