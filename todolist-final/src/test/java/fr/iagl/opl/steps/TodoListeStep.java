package fr.iagl.opl.steps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

	@Given("^La TODO liste (\\w+) existe$")
	public void la_TODO_liste_todel_existe(String arg1) throws Throwable {
		Assert.assertNotNull(listRepository.findByName(arg1));
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
		res = controller.createList(listEntity, Mockito.anyObject(), this.model);
	}
	
	@Then("^Je suis redirige sur la page erreur work existe deja$")
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
	
	@Given("^Je veux creer une TODO liste avec le nom redirection$")
	public void je_veux_creer_une_TODO_liste_avec_le_nom_redirection() throws Throwable {
		this.currentList = "redirection";
	}

	@Given("^La TODO liste redirection n'existe pas$")
	public void la_TODO_liste_redirection_n_existe_pas() throws Throwable {
		Assert.assertNull(listRepository.findByName("redirection"));
	}

	@Then("^Je suis redirige vers la liste des todolists$")
	public void je_suis_redirige_vers_la_liste_des_todolists() throws Throwable {
		Assert.assertEquals("todolists", res);
	}
	
	@Given("^Je veux supprimer la TODO liste avec le nom (\\w+)$")
	public void je_veux_supprimer_la_TODO_liste_avec_le_nom_todel(String arg1) throws Throwable {
	    this.currentList = arg1;
	}

	@When("^Je clique sur le bouton supprimer de la TODO Liste (\\w+)$")
	public void je_clique_sur_le_bouton_supprimer_de_la_TODO_Liste_todel(String arg1) throws Throwable {
		res = controller.supprimer("/delete/" + arg1, model);
	}

	@Then("^La TODO liste (\\w+) est supprimee$")
	public void la_TODO_liste_todel_est_supprimee(String arg1) throws Throwable {
		Assert.assertNull(listRepository.findByName(arg1));
	}

}
