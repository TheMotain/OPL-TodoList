package fr.iagl.opl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class List {

	@Id
	@Column(name = "name")
    private String name;

	@OneToMany(mappedBy="list", cascade={CascadeType.ALL})
	private java.util.List<Task> tasks;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(java.util.List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		List other = (List) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
