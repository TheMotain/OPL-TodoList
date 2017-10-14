package fr.iagl.opl.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.iagl.opl.SpringIntegrationTest;

public class GestionTaskStep extends SpringIntegrationTest{
	@Given("^J ai cree une liste todo$")
	public void j_ai_cree_une_liste_todo() throws Throwable {
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

	@When("^Je remplis le formulaire avec task(\\d+), <description>, (\\d+), false$")
	public void je_remplis_le_formulaire_avec_task_description_false(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je valide creation$")
	public void je_valide_creation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Un task <name est cree$")
	public void un_task_name_est_cree() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^J ai cree un task task(\\d+) dans la liste todo$")
	public void j_ai_cree_un_task_task_dans_la_liste_todo(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Je veux modifier un task$")
	public void je_veux_modifier_un_task() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je clique le bouton modifier un task$")
	public void je_clique_le_bouton_modifier_un_task() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je modifie son task(\\d+), <description>, (\\d+), false$")
	public void je_modifie_son_task_description_false(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je valide modification$")
	public void je_valide_modification() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Le task task(\\d+) est modifie$")
	public void le_task_task_est_modifie(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^J ai (\\d+) task dans ma liste$")
	public void j_ai_task_dans_ma_liste(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je finis <finished> task dans ma liste$")
	public void je_finis_finished_task_dans_ma_liste() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^Je supprime <delete> task$")
	public void je_supprime_delete_task() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
