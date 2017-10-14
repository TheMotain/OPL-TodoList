package fr.iagl.opl.steps;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.controller.ListController;
import fr.iagl.opl.controller.TaskController;
import fr.iagl.opl.entity.Task;
import fr.iagl.opl.repository.ListRepository;
import fr.iagl.opl.repository.TaskRepository;
import junit.framework.Assert;

@RunWith(Cucumber.class)
public class GestionTaskStep extends SpringIntegrationTest{
	
	private Task taskEntity;
	
	private String cuurentTask;
	
	private String res;
	
	private ModelMap model;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskController taskController;
	
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private ListController listController;
	
	@Before
	public void setup() {
		taskController.setTaskRepository(taskRepository);
		listController.setListRepository(listRepository);
	}
	
	
}
