package fr.iagl.opl.steps;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.iagl.opl.SpringBootWebApplication;
import fr.iagl.opl.SpringIntegrationTest;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringBootWebApplication.class, loader = ConfigFileApplicationContextInitializer.class)
//@WebAppConfiguration
public class TodoListeStep extends SpringIntegrationTest {
	@Given("^La TODO liste work(\\d+) existe$")
	public void la_TODO_liste_work_existe(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Je veux creer une TODO Liste work(\\d+)$")
	public void je_veux_creer_une_TODO_Liste_work(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Je remplis le formulaire$")
	public void je_remplis_le_formulaire() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Valide la création$")
	public void valide_la_création() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Une erreur est affichee work(\\d+) existe deja$")
	public void une_erreur_est_affichee_work_existe_deja(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
