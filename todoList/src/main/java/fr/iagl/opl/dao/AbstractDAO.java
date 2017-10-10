package fr.iagl.opl.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<T extends Serializable,PK extends Serializable> implements DAOInterface<T,PK> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	private final Class persistentClass;

	@SuppressWarnings("rawtypes")
	public AbstractDAO() {
		this.persistentClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	@Override
	public void persist(T entity) {
		getSession().persist(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}
}
