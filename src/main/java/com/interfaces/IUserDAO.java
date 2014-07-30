package com.interfaces;

import java.util.List;

import com.entity.User;
import com.util.IDAO;

public interface IUserDAO extends IDAO<User>{

	List<User> listaUsuario (User entidade);
	User login(String username, String password);

}
