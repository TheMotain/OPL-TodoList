package fr.iagl.opl.entity;

import java.io.Serializable;

public abstract class AbstractEntity<PK extends Serializable> {
	
	/**
	 * The entity id
	 */
	private PK id;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}
}
