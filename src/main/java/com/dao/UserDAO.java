package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.User;
import com.interfaces.IUserDAO;
import com.util.AbastractDAO;
 
@Repository
@SuppressWarnings("unchecked")
public class UserDAO  extends AbastractDAO<User> implements IUserDAO {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    @Override
    public User login(String username, String password) {
        List<User> lista = getEntityManager().createQuery("select u from User u where u.username = :username and u.password= :password")
        .setParameter("username", username)
        .setParameter("password", password)
        .getResultList();
 
        if (lista == null || lista.isEmpty() || lista.size() > 1) {
            return null;
        }
        return (User) lista.get(0);
    }

	@Override
	public List<User> listaUsuario(User entidade) {
		List<User> lista = getEntityManager().createQuery("select u from User u ")
				.getResultList();	
		return lista;
	}
}
