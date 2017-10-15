package fr.iagl.opl.controller;

import java.util.Date;

import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	public RedirectView createTask(@PathVariable("listname") String listname,@RequestParam("name")String name, @RequestParam("description") String description, ModelMap model) {
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
	public RedirectView doneTask(@PathVariable("taskId") String taskId, ModelMap model){
		if(StringUtils.isEmpty(taskId) || !StringUtils.isNumeric(taskId)){
			return new RedirectView(PageEnum.ERROR_WHEN_UPDATE_TASK.getUrl());
		}
		Task task = taskRepository.findOne(new Long(taskId));
		if(task == null){
			return new RedirectView(PageEnum.ERROR_WHEN_UPDATE_TASK.getUrl());
		}
		task.setDone(true);
		taskRepository.save(task);
		return new RedirectView(PageEnum.HOME.getUrl());
	}
	
	@RequestMapping(value = "/deleteTask/{taskId}", method = RequestMethod.GET)
	public RedirectView deleteTask(@PathVariable("taskId") String taskId, ModelMap model){
		if(StringUtils.isEmpty(taskId) || !StringUtils.isNumeric(taskId)){
			return new RedirectView(PageEnum.ERROR_WHEN_UPDATE_TASK.getUrl());
		}
		taskRepository.delete(new Long(taskId));
		return new RedirectView(PageEnum.HOME.getUrl());
	}
	
	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public void setListRepository(ListRepository listRepository) {
		this.listRepository = listRepository;
	}
}
