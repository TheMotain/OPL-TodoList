package fr.iagl.opl.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import fr.iagl.opl.entity.List;
import fr.iagl.opl.entity.Task;
import fr.iagl.opl.enums.ModelAttributeEnum;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;

@Controller
public class ListController {

	@Autowired
	private HomeController homeController;
	
	@Autowired
	private ListRepository listRepository;

	@RequestMapping(value = "/createTodoList", method = RequestMethod.POST)
	public RedirectView createList(@ModelAttribute("listForm") List listForm, BindingResult result, ModelMap model) {
		model.put(ModelAttributeEnum.LIST_FORM.getAttribute(), new List());
		if (null == listRepository.findByName(listForm.getName())) {
			listRepository.save(listForm);
			return new RedirectView(PageEnum.HOME.getUrl());
		}
		return new RedirectView(PageEnum.ERROR_LIST_ALREADY_EXISTS.getUrl());
	}
	
	@RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
	public RedirectView supprimer(@PathParam("name") String name, ModelMap model) {
		if(null != listRepository.findByName(name)){
			listRepository.delete(name);
			return new RedirectView(PageEnum.HOME.getUrl());
		}
		return new RedirectView(PageEnum.ERROR_LIST_NOT_EXISTS.getUrl());
	}

	public void setListRepository(ListRepository listRepository) {
		this.listRepository = listRepository;
	}

}
