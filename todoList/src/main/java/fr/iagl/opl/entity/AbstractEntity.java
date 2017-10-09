package fr.iagl.opl.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

public abstract class AbstractEntity<PK extends Serializable> {
	
	/**
	 * The entity id
	 */
	@EmbeddedId
	private PK id;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}
}
