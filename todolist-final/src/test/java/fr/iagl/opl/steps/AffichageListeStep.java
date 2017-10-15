package fr.iagl.opl.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import fr.iagl.opl.controller.HomeController;
import fr.iagl.opl.dto.ListDTO;
import fr.iagl.opl.dto.TaskDTO;
import fr.iagl.opl.enums.ModelAttributeEnum;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;
import fr.iagl.opl.repository.TaskRepository;
import fr.iagl.opl.utils.DateUtils;

@RunWith(Cucumber.class)
public class AffichageListeStep {

	private fr.iagl.opl.entity.List currentList;

	private List<String> todolists;

	private ModelMap model;

	private String res;

	@Autowired
	private HomeController homeController;

	@Autowired
	private ListRepository listRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Before
	public void setup() {
		homeController.setListRepository(listRepository);
	}

	@Given("^J ai les todo listes work, home, todel, display$")
	public void j_ai_les_todo_listes_work_home_todel() throws Throwable {
		Assert.assertTrue(listRepository.exists("work"));
		Assert.assertTrue(listRepository.exists("home"));
		Assert.assertTrue(listRepository.exists("todel"));
		Assert.assertTrue(listRepository.exists("display"));
		todolists = new ArrayList<String>();
		todolists.add("work");
		todolists.add("home");
		todolists.add("todel");
		todolists.add("display");
	}

	@When("^Je veux regarder toutes les listes$")
	public void je_veux_regarder_toutes_les_listes() throws Throwable {
		model = new ModelMap();
		res = homeController.home(model);
	}

	@SuppressWarnings("unchecked")
	@Then("^Toutes les listes sont affichees$")
	public void toutes_les_listes_sont_affichees() throws Throwable {
		Object result = model.get(ModelAttributeEnum.TODOLISTS.getAttribute());
		Assert.assertTrue(result instanceof List);
		List<ListDTO> listsDTO = (List<ListDTO>) result;
		mainLoop: for (String list : todolists) {
			for (ListDTO listDTO : listsDTO) {
				if (listDTO.getName().equals(list)) {
					continue mainLoop;
				}
			}
			Assert.fail();
		}
	}

	@Given("^J ai une todo liste avec le nom (\\w+)$")
	public void j_ai_une_todo_liste_avec_le_nom_work(String arg) throws Throwable {
		Assert.assertTrue(listRepository.exists(arg));
		currentList = new fr.iagl.opl.entity.List();
		currentList.setName(arg);
	}

	@Given("^J ai une tache (\\w+) dans la liste$")
	public void j_ai_une_tache_meeting_dans_la_liste_work(String task) throws Throwable {
		Assert.assertNotNull(taskRepository.findTaskByNameAndList(task, currentList));
	}

	@Then("^La page home est affichee$")
	public void la_page_home_est_affichee() throws Throwable {
		Assert.assertEquals(PageEnum.HOME.getPage(), res);
	}

	@SuppressWarnings("unchecked")
	@Then("^Le contenu de tache (\\w+) avec les attributs (\\d+), (\\w+), (\\d+)-(\\d+)-(\\d+), (\\w+) sont affiche$")
	public void le_contenu_de_tache_meeting_avec_hello_false_sont_affiche(String taskname, long id, String description,
			int year, int month, int day, String done) throws Throwable {
		Object result = model.get(ModelAttributeEnum.TODOLISTS.getAttribute());
		Assert.assertTrue(result instanceof List);
		List<ListDTO> lists = (List<ListDTO>) result;
		ListDTO listDTO = null;
		for (ListDTO list : lists) {
			if (list.getName().equals(currentList.getName())) {
				listDTO = list;
				break;
			}
		}
		Assert.assertNotNull(listDTO);
		for (TaskDTO task : listDTO.getListToDisplay()) {
			if (task.getId().longValue() == id && task.getName().equals(taskname)
					&& task.getDescription().equals(description)
					&& task.getCreationDate()
							.compareTo(DateUtils.parseDateStandardFormat(String.format("%s-%s-%s", year, month, day))) == 0
					&& task.isDone() == new Boolean(done).booleanValue()) {
				return;
			}
		}
		Assert.fail();
	}

	private int nbTaskTotal;

	@Given("^j'ai une todoListe avec le nom (\\w+)$")
	public void j_ai_une_todoListe_avec_le_nom_work(String list) throws Throwable {
		this.currentList = new fr.iagl.opl.entity.List();
		this.currentList.setName(list);
	}

	@Given("^j'ai (\\d+) taches qui lui sont ratachees$")
	public void j_ai_taches_qui_lui_sont_ratachees(int nbTask) throws Throwable {
		nbTaskTotal = nbTask;
	}

	@SuppressWarnings("unchecked")
	@Then("^La liste retournee contient (\\d+)$")
	public void la_liste_retournee_contient(int lines) throws Throwable {
		Assert.assertEquals(((int) nbTaskTotal / 5) + (nbTaskTotal % 5 == 0 ? 0 : 1), lines);
		List<ListDTO> lists = (List<ListDTO>) model.get(ModelAttributeEnum.TODOLISTS.getAttribute());
		ListDTO list = null;
		for (ListDTO listTmp : lists) {
			if (listTmp.getName().equals(currentList.getName())) {
				list = listTmp;
				break;
			}
		}
		Assert.assertNotNull(list);
		Assert.assertEquals(lines, list.getFormatedListToDisplay().size());
	}

	@SuppressWarnings("unchecked")
	@Then("^Une ligne contient au maximum 5 taches$")
	public void une_ligne_contient_au_maximum_taches() throws Throwable {
		List<ListDTO> lists = (List<ListDTO>) model.get(ModelAttributeEnum.TODOLISTS.getAttribute());
		ListDTO list = null;
		for (ListDTO listTmp : lists) {
			if (listTmp.getName().equals(currentList.getName())) {
				list = listTmp;
				break;
			}
		}
		Assert.assertNotNull(list);
		for (TaskDTO[] tasks : list.getFormatedListToDisplay()) {
			Assert.assertTrue(tasks.length <= 5);
		}
	}

}
