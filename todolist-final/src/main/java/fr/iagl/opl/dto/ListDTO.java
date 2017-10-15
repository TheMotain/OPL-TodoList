package fr.iagl.opl.dto;

import java.util.ArrayList;
import java.util.List;

import fr.iagl.opl.entity.Task;

public class ListDTO {
	
	public static final int MAX_TASK_TO_DISPLAY_ON_A_LINE = 5;
	
	private List<Task[]> listToDisplay;
	
	private String name;

	public ListDTO(){
		this.listToDisplay = new ArrayList<>();
	}
	
	public List<Task[]> getListToDisplay() {
		return listToDisplay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
