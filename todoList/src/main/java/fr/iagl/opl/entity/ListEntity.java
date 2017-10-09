package fr.iagl.opl.entity;

import java.io.Serializable;

import fr.iagl.opl.entity.pk.ListPK;

public class ListEntity extends AbstractEntity<ListPK> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4740071118553580535L;
	
	/**
	 * Nom de la liste
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
