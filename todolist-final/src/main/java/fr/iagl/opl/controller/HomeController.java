package fr.iagl.opl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.iagl.opl.entity.List;
import fr.iagl.opl.enums.ModelAttributeEnum;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;

@Controller
public class HomeController {

	@Autowired
	private ListRepository listRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model){
		model.addAttribute(ModelAttributeEnum.LIST_FORM.getAttribute(), new List());
		return PageEnum.HOME.getPage();
	}

	public void setListRepository(ListRepository listRepository) {
		this.listRepository = listRepository;
	}
}
