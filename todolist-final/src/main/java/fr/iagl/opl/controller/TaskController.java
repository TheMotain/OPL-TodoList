package fr.iagl.opl.controller;

import javax.websocket.server.PathParam;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import fr.iagl.opl.entity.Task;
import fr.iagl.opl.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;


	@RequestMapping(value = "/createTask/{listname}", method = RequestMethod.POST)
	public RedirectView createTask(@PathParam("listname") String listname,@RequestParam("name")String name, @RequestParam("description") String description, ModelMap model) {
		System.out.println(name);
		System.out.println(description);
		// se baser sur la méthode qui fait la même chose pour les listes
		// attention dans le paramètre listname est au format string pour pouvoir faire la jointure il faut:
		// creer une List et lui mettre le nom correspondant
		// mettre la list créé dans l'objet taskForm
		// tu peux ensuite persister
		throw new NotYetImplementedException();
	}
	
	@RequestMapping(value = "/done/{taskId}", method = RequestMethod.GET)
	public RedirectView doneTask(@PathParam("taskId") String taskId, ModelMap model){
		// Attention ici l'id est en String il faudra le parse avant de pourvoir récupérer l'entité à mettre à jour
		// utilise la méthode save du repository pour sauvegarder l'update
		// attention donc à bien récupérer l'entité d'origine 
		throw new NotYetImplementedException();
	}
	
	@RequestMapping(value = "/delete/{taskId}", method = RequestMethod.GET)
	public RedirectView deleteTask(@PathParam("taskId") String taskId, ModelMap model){
		// attention ici idem pour le type du paramètre
		// par contre ici tu peux simplement utiliser la mthode delete avec l'id en paramètre
		throw new NotYetImplementedException();
	}
	
	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	

}
