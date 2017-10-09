package fr.iagl.opl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import fr.iagl.opl.entity.pk.ListPK;

@Table(name = "List")
public class ListEntity extends AbstractEntity<ListPK> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4740071118553580535L;
	
	/**
	 * Nom de la liste
	 */
	@Column(name="NAME")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
