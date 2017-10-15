package fr.iagl.opl.steps;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.RedirectView;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.controller.ListController;
import fr.iagl.opl.controller.TaskController;
import fr.iagl.opl.entity.List;
import fr.iagl.opl.entity.Task;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;
import fr.iagl.opl.repository.TaskRepository;

@RunWith(Cucumber.class)
public class GestionTaskStep extends SpringIntegrationTest{

	private Task taskEntity;
	
	private List listEntity;
	
	private String cuurentTask;
	
	private String currentList;
	
	private String taskId;
	
	private Boolean taskEtat;
	
	private RedirectView res;
	
	private ModelMap model;
	
	private java.util.List<Task> tasks;
	
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
	
	@Given("^J ai cree une liste work$")
	public void j_ai_cree_une_liste_work() throws Throwable {
	    this.currentList = "work";
	    this.listEntity = new List();
	    this.listEntity.setName(currentList);
	}

	@Given("^Je veux creer un task avec le nom meeting$")
	public void je_veux_creer_un_task_avec_le_nom_meeting() throws Throwable {
	    this.cuurentTask = "meeting";
	}

	@When("^Je clique le bouton et remplis le formulaire avec meeting, null, null, false$")
	public void je_clique_le_bouton_et_remplis_le_formulaire_avec_meeting_null_null_false() throws Throwable {
	    this.model = new ModelMap();
	    this.taskEntity = new Task();
	    this.taskEntity.setName(cuurentTask);
	    this.taskEntity.setList(listEntity);
	    this.taskEntity.setDescription(null);
	    this.taskEntity.setCreation_date(null);
	    this.taskEntity.setDone(false); 
	    
	    tasks = new ArrayList<Task>();
	    tasks.add(taskEntity);
	    listEntity.setTasks(tasks);
	}

	@When("^Je valide creation$")
	public void je_valide_creation() throws Throwable {
	    res = taskController.createTask(currentList, Mockito.anyObject(), Mockito.anyObject(), this.model);
	}

	@Given("^Je veux finir le task lunch dans ma liste home$")
	public void je_veux_finir_le_task_lunch_dans_ma_liste_home() throws Throwable {
		this.currentList = "home";
		this.listEntity = new List();
		this.listEntity.setName(currentList);
		tasks = new ArrayList<Task>();
	    tasks.add(taskEntity);
	    listEntity.setTasks(tasks);
	    
		this.cuurentTask = "lunch";
		this.taskEntity = new Task();
		this.taskEntity.setName(cuurentTask);
		this.taskEntity.setList(listEntity);
		
	}

	@Given("^Task lunch a son etat initial false$")
	public void task_lunch_a_son_etat_initial_false() throws Throwable {
	    Assert.assertFalse(taskEntity.isDone());
	}

	@When("^Je change son etat a true$")
	public void je_change_son_etat_a_true() throws Throwable {
	    res = taskController.doneTask(taskId, model);
	}

	@Then("^Je suis redirige vers la page de resultat$")
	public void je_suis_redirige_vers_la_page_de_resultat() throws Throwable {
		Assert.assertEquals(PageEnum.HOME.getUrl(), res.getUrl());
//		throw new PendingException();
	}

	@Given("^Je veux finir le task dinner dans ma liste home$")
	public void je_veux_finir_le_task_dinner_dans_ma_liste_home() throws Throwable {
		this.currentList = "home";
		this.listEntity = new List();
		this.listEntity.setName(currentList);
		tasks = new ArrayList<Task>();
	    tasks.add(taskEntity);
	    listEntity.setTasks(tasks);
	    
		this.cuurentTask = "dinner";
		this.taskEntity = new Task();
		this.taskEntity.setName(cuurentTask);
		this.taskEntity.setList(listEntity);
	}

	@Given("^Task dinner a son etat initial true$")
	public void task_dinner_a_son_etat_initial_true() throws Throwable {
		this.taskEtat = true;
	    this.taskEntity.setDone(taskEtat);
	}

	@Given("^J ai task homework dans ma liste school$")
	public void j_ai_task_homework_dans_ma_liste_school() throws Throwable {
		this.currentList = "school";
		this.listEntity = new List();
		this.listEntity.setName(currentList);
		tasks = new ArrayList<Task>();
	    tasks.add(taskEntity);
	    listEntity.setTasks(tasks);
	    
		this.cuurentTask = "homework";
		this.taskEntity = new Task();
		this.taskEntity.setName(cuurentTask);
		this.taskEntity.setList(listEntity);
	}

	@When("^Je supprime task homework$")
	public void je_supprime_task_homework() throws Throwable {
		res = taskController.deleteTask(taskId, model);
	}

	@Then("^Le task homework n'existe plus dans ma liste$")
	public void le_task_homework_n_existe_plus_dans_ma_liste() throws Throwable {
	    Assert.assertNull(taskRepository.findTaskByNameAndList("homework", this.listEntity));
	}
	

}
