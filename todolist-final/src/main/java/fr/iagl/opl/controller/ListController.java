package fr.iagl.opl.controller;

import javax.validation.Valid;

import org.apache.jasper.util.UniqueAttributesImpl;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.iagl.opl.entity.List;
import fr.iagl.opl.repository.ListRepository;

@Controller
public class ListController {
	
	@Autowired
	private ListRepository listRepository;

	@RequestMapping(value = "/createTodoList", method = RequestMethod.POST)
	public String createList(@Valid @ModelAttribute("list") List entity, ModelMap model){
		listRepository.save(entity);
		return null;
	}
	
	public ListRepository getListRepository() {
		return listRepository;
	}

	public void setListRepository(ListRepository listRepository) {
		this.listRepository = listRepository;
	}
	
}
