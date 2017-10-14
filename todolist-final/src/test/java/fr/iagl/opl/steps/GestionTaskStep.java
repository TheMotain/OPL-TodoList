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
	
	@Given("^J ai cree une liste work$")
	public void j_ai_cree_une_liste_work() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Je veux creer un task$")
	public void je_veux_creer_un_task() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je clique le bouton creer un task$")
	public void je_clique_le_bouton_creer_un_task() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je remplis le formulaire avec meeting, null, (\\d+), false$")
	public void je_remplis_le_formulaire_avec_meeting_null_false(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je valide creation$")
	public void je_valide_creation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Un task meeting est cree$")
	public void un_task_meeting_est_cree() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Je veux finir lunch dans ma liste home$")
	public void je_veux_finir_lunch_dans_ma_liste_home() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Task lunch a son etat initial false$")
	public void task_lunch_a_son_etat_initial_false() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je change son etat a true$")
	public void je_change_son_etat_a_true() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Je suis redirige vers le page de resultat$")
	public void je_suis_redirige_vers_le_page_de_resultat() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Je veux finir dinner dans ma liste home$")
	public void je_veux_finir_dinner_dans_ma_liste_home() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Task dinner a son etat initial true$")
	public void task_dinner_a_son_etat_initial_true() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^J ai task homework dans ma liste school$")
	public void j_ai_task_homework_dans_ma_liste_school() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je supprime task homework$")
	public void je_supprime_task_homework() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Le task n'existe plus dans ma liste$")
	public void le_task_n_existe_plus_dans_ma_liste() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
