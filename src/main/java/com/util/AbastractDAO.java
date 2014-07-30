package com.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.FlushMode;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class AbastractDAO<E> implements IDAO<E>{
	
	@PersistenceContext protected EntityManager entityManager;
	protected  HibernateTemplate hibernateTemplate;



/*	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		if(hibernateTemplate == null){
			hibernateTemplate = new HibernateTemplate( sessionFactory);
		}
	}  */
	
	public void salvar(E entidade) {
		getEntityManager().persist(entidade);
		flush();
	}
	
	public void salvarLista(Collection<E> lista) {
		Iterator<E> i = lista.iterator();  
        while(i.hasNext()){  
            Object entidade = new Object();                
            entidade = i.next();  
            getEntityManager().persist(entidade);
        }
        
        flush();
	}
	
	public void atualizarLista(Collection<E> lista) {
		Iterator<E> i = lista.iterator();  
        while(i.hasNext()){  
            Object entidade = new Object();                
            entidade = i.next();  
            getEntityManager().merge(entidade);
        }
        
        flush();
	}
	
	public E atualizar(E entidade, boolean validaDataBloqueio) {
		entityManager.clear();
		E novaEntidade = getEntityManager().merge(entidade);
		flush();
		return novaEntidade;
	}
	
	public E atualizar(E entidade) {
		return atualizar(entidade, true);
	}
	
	public void excluir(E entidade) {
		getEntityManager().remove(entidade);
		flush();
	}
	
	public void excluirLista(Collection<E> entities){
		for (Object entity : entities) {
			getEntityManager().remove(entity);
			flush();
		}
	}
	
	public void bloquear(E entidade) {
		getEntityManager().merge(entidade);
		flush();
	}
	
	public void desbloquear(E entidade) {
		getEntityManager().merge(entidade);
		flush();
	}
	
	public void clear() {
		getEntityManager().clear();
	}
	
	public void flush() {
		getEntityManager().flush();
	}
	
	public void refresh(E entidade) {
		getEntityManager().refresh(entidade);
	}
	
	public E find(Object id) {
		return (E) getEntityManager().find(getClassEntidade(), id);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	protected Class<E> getClassEntidade() {
		Class<E> clazz = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;
	}
	
	public void salvaOuAtualizaCollection(Collection<E> lista) {
		hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		hibernateTemplate.saveOrUpdateAll(lista);
		hibernateTemplate.flush();
	}
	
	@SuppressWarnings("unused")
	private Object invocaMetodo(String nomeMetodo, Object objeto) {
		
		try {
			Method metodo = objeto.getClass().getMethod(nomeMetodo);
			return metodo.invoke(objeto);
			
		} catch (SecurityException e) {
			return null;
		} catch (NoSuchMethodException e) {
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		} catch (InvocationTargetException e) {
			return null;
		}
		
	}
	
	@SuppressWarnings("unused")
	private Object invocaMetodo(String nomeMetodo, Object[] parametros, Class<?>... tiposParametros) {
		
		try {
			Method metodo = this.getClass().getMethod(nomeMetodo, tiposParametros);
			return metodo.invoke(this,parametros);
			
		} catch (SecurityException e) {
			return null;
		} catch (NoSuchMethodException e) {
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		} catch (InvocationTargetException e) {
			return null;
		}
		
	}
	
}
