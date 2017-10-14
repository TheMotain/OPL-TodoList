package fr.iagl.opl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.iagl.opl.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;

	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	

}
