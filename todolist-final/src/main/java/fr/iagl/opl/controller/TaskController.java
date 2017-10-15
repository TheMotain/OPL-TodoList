package fr.iagl.opl.controller;

import java.util.Date;

import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import fr.iagl.opl.entity.List;
import fr.iagl.opl.entity.Task;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;
import fr.iagl.opl.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ListRepository listRepository;

	@RequestMapping(value = "/createTask/{listname}", method = RequestMethod.POST)
	public RedirectView createTask(@PathParam("listname") String listname,@RequestParam("name")String name, @RequestParam("description") String description, ModelMap model) {
		if(StringUtils.isEmpty(listname) || StringUtils.isEmpty(name)){
			return new RedirectView(PageEnum.ERROR_WHEN_CREATING_TASK.getUrl());
		}
		List list = listRepository.findByName(listname);
		if(list == null){
			return new RedirectView(PageEnum.ERROR_WHEN_CREATING_TASK.getUrl());
		}
		Task toPersist = new Task();
		toPersist.setList(list);
		toPersist.setName(name);
		toPersist.setDescription(description);
		toPersist.setDone(false);
		toPersist.setCreation_date(new Date());
		taskRepository.save(toPersist);
		return new RedirectView(PageEnum.HOME.getUrl());
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
	
	public void setListRepository(ListRepository listRepository) {
		this.listRepository = listRepository;
	}
}
