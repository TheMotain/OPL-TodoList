package fr.iagl.opl.controller;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import fr.iagl.opl.entity.Task;
import fr.iagl.opl.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;



	public String createTask(Task taskEntity, Object anyObject, ModelMap model) {
		throw new NotYetImplementedException();
	}
	
	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	

}
