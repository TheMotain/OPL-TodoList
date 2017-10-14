package fr.iagl.opl.steps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.controller.ListController;
import fr.iagl.opl.entity.List;
import fr.iagl.opl.repository.ListRepository;


@RunWith(Cucumber.class)
public class TodoListeStep extends SpringIntegrationTest {
	
	private List listEntity;
	
	private String currentList;
	
	private String res;
	
	private ModelMap model;
	
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private ListController controller;
	
	@Before
	public void setup(){
		controller.setListRepository(listRepository);
	}
	
	@Given("^La TODO liste work existe$")
	public void la_TODO_liste_work_existe() throws Throwable {
		Assert.assertNotNull(listRepository.findByName("work"));
	}

	@Given("^Je veux creer une TODO Liste work$")
	public void je_veux_creer_une_TODO_Liste_work() throws Throwable {
		this.currentList = "work";
	}
	
	@When("^Je remplis le formulaire$")
	public void je_remplis_le_formulaire() throws Throwable {
		this.model = new ModelMap();
		this.listEntity = new List();
		this.listEntity.setName(this.currentList);
	}

	@When("^Valide la creation$")
	public void valide_la_creation() throws Throwable {
		res = controller.createList(listEntity, this.model);
	}
	
	@Then("^Une erreur est affichee work existe deja$")
	public void une_erreur_est_affichee_work_existe_deja() throws Throwable {
		Assert.assertEquals("errorListAlreadyExists", res);
	}

	@Given("^Je veux creer une TODO liste avec le nom work(\\d+)$")
	public void je_veux_creer_une_TODO_liste_avec_le_nom_work(int arg) throws Throwable {
		this.currentList = "work" + arg;
	}

	@Given("^La TODO liste work(\\d+) n'existe pas$")
	public void la_TODO_liste_work_n_existe_pas(int arg) throws Throwable {
		Assert.assertNull(listRepository.findByName("work" + arg));
	}

	@Then("^La TODO liste work(\\d+) est creee$")
	public void la_TODO_liste_work_est_creee(int arg) throws Throwable {
		listEntity = listRepository.findByName("work"+arg);
		Assert.assertNotNull(listEntity);
		Assert.assertEquals("work"+arg, listEntity.getName());
	}
}
