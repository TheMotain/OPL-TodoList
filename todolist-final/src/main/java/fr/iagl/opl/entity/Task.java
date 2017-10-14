package fr.iagl.opl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@Column(name = "name")
	private String name;
	private String list;
	private String description;
	private int creation_date;
	private boolean done;
	
	public String getName() {
		return name;
	}
	
	public String getList() {
		return list;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getCreation_date() {
		return creation_date;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setList(String list) {
		this.list = list;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCreation_date(int creation_date) {
		this.creation_date = creation_date;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
