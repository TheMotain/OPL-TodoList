package fr.iagl.opl.dao;

import java.io.Serializable;

public interface DAOInterface <T extends Serializable, PK extends Serializable> {
	
	public T getByKey(PK key);

	public void persist(T entity);

	public void delete(T entity);
}
