package fr.iagl.opl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.iagl.opl.entity.ListEntity;
import fr.iagl.opl.service.ListService;

@Controller
public class DashBordController {

	@Autowired
	private ListService listService;

	@RequestMapping("/test")
	public ModelAndView showMessage() {
		ListEntity e = listService.findById();
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", e.getId().getId());
		mv.addObject("name", e.getName());
		return mv;
	}
	
	public void setListService(ListService listService) {
		this.listService = listService;
	}
	
	
}
