package fr.iagl.opl.steps;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.RedirectView;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.controller.TaskController;
import fr.iagl.opl.entity.List;
import fr.iagl.opl.entity.Task;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;
import fr.iagl.opl.repository.TaskRepository;

@RunWith(Cucumber.class)
public class GestionTaskStep extends SpringIntegrationTest{
	
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskController taskController;
	
	private String currentTask;
	
	private String currentList;
	
	private Task currentTaskEntity;
	
	private String currentDescription;
	
	private RedirectView res;
	
	@Before
	public void setup(){
		taskController.setListRepository(listRepository);
		taskController.setTaskRepository(taskRepository);
	}
	
	@Given("^La liste work existe$")
	public void la_liste_work_existe() throws Throwable {
		Assert.assertNotNull(listRepository.findByName("work"));
		currentList = "work";
	}

	@Given("^Je veux creer un task avec le nom (\\w+) dans la liste$")
	public void je_veux_creer_un_task_avec_le_nom_meeting_dans_la_liste(String taskName) throws Throwable {
		currentTask = taskName;
	}

	@When("^Je remplis le formulaire avec le nom (\\w+) et la description (\\w+)$")
	public void je_remplis_le_formulaire_avec_le_nom_meeting_et_la_description_null(String name, String description) throws Throwable {
		Assert.assertEquals(currentTask, name);
		currentDescription = description;
	}

	@When("^Je valide la creation$")
	public void je_valide_la_creation() throws Throwable {
		res = taskController.createTask(currentList, currentTask, currentDescription, new ModelMap());
	}

	@Then("^La task est cree, la date du jour est mise automatiquement et le statut est a false$")
	public void la_task_est_cree() throws Throwable {
		List list = new List();
		list.setName(currentList);
		Task task = taskRepository.findTaskByNameAndList(currentTask, list);
		Assert.assertNotNull(task);
		Assert.assertEquals(currentDescription, task.getDescription());
		Assert.assertFalse(task.isDone());
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(task.getCreation_date());
		Assert.assertEquals(year, cal.get(Calendar.YEAR));
		Assert.assertEquals(month, cal.get(Calendar.MONTH));
		Assert.assertEquals(day, cal.get(Calendar.DAY_OF_MONTH));
	}

	@Then("^Je suis redirige vers la page des resultats$")
	public void je_suis_redirige_vers_la_page_des_resultats() throws Throwable {
		Assert.assertEquals(PageEnum.HOME.getUrl(), res.getUrl());
	}

	@Given("^La task (\\w+) existe dans la liste (\\w+)$")
	public void la_lunch_existe_dans_la_liste_home(String task, String listname) throws Throwable {
		List list = new List();
		list.setName(listname);
		currentTaskEntity = taskRepository.findTaskByNameAndList(task, list);
		Assert.assertNotNull(currentTaskEntity);
		currentTask = task;
		currentList = listname;
	}

	@Given("^Son statut est a l'etat (\\w+)$")
	public void son_statut_est_a_l_etat_true(String status) throws Throwable {
		if(new Boolean(status).booleanValue()){
			Assert.assertTrue(currentTaskEntity.isDone());
		}else{
			Assert.assertFalse(currentTaskEntity.isDone());
		}
	}

	@When("^Je veux finir la tache$")
	public void je_veux_finir_la_tache() throws Throwable {
		res = taskController.doneTask(currentTaskEntity.getId().toString(), new ModelMap());
	}

	@Then("^Le statut de la tache est done$")
	public void le_statut_de_la_tache_est_done() throws Throwable {
		List list = new List();
		list.setName(currentList);
		currentTaskEntity = taskRepository.findTaskByNameAndList(currentTask, list);
		Assert.assertNotNull(currentTaskEntity);
		Assert.assertTrue(currentTaskEntity.isDone());
	}

	@When("^Je supprime la supprime$")
	public void je_supprime_la_supprime() throws Throwable {
		res = taskController.deleteTask(currentTaskEntity.getId().toString(), new ModelMap());
	}

	@Then("^Le task (\\w+) n'existe plus presente dans la liste$")
	public void le_task_homework_n_existe_plus_presente_dans_la_liste(String listname) throws Throwable {
		List list = new List();
		list.setName(listname);
		Assert.assertNull(taskRepository.findTaskByNameAndList(currentTask, list));
	}	

}
