package fr.iagl.opl.controller;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.iagl.opl.dto.ListDTO;
import fr.iagl.opl.entity.List;
import fr.iagl.opl.enums.ModelAttributeEnum;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;

@Controller
public class HomeController {

	@Autowired
	private ListRepository listRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Transactional
	public String home(ModelMap model){
		java.util.List<List> todolists = new ArrayList<List>();
		listRepository.findAll().iterator().forEachRemaining(todolists::add);
		model.addAttribute(ModelAttributeEnum.TODOLISTS.getAttribute(), transformListsToDTO(todolists));
		model.addAttribute(ModelAttributeEnum.LIST_FORM.getAttribute(), new List());
		return PageEnum.HOME.getPage();
	}
	
	@RequestMapping(value = "/errorListAlreadyExists", method = RequestMethod.GET)
	public String redirectErrorListAlreadyExists(ModelMap model){
		return PageEnum.ERROR_LIST_ALREADY_EXISTS.getPage();
	}
	
	@RequestMapping(value = "/errorListNotExists", method = RequestMethod.GET)
	public String redirectErrorListNotExists(ModelMap model){
		return PageEnum.ERROR_LIST_NOT_EXISTS.getPage();
	}
	
	@RequestMapping(value = "/errorWhenCreatingTask", method = RequestMethod.GET)
	public String redirectErrorWhenCreatingTask(ModelMap model){
		return PageEnum.ERROR_WHEN_CREATING_TASK.getPage();
	}

	@RequestMapping(value = "/errorWhenUpdateTask", method = RequestMethod.GET)
	public String redirectErrorWhenUpdateTask(ModelMap model){
		return PageEnum.ERROR_WHEN_UPDATE_TASK.getPage();
	}
	
	private java.util.List<ListDTO> transformListsToDTO(java.util.List<List> todolists) {
		java.util.List<ListDTO> output = new ArrayList<ListDTO>();
		for(List list : todolists){
			ListDTO dto = new ListDTO();
			dto.setName(list.getName());
			dto.mapListTaskEntityToListTaskDTO(list.getTasks());
			output.add(dto);
		}
		return output;
	}

	public void setListRepository(ListRepository listRepository) {
		this.listRepository = listRepository;
	}
}
