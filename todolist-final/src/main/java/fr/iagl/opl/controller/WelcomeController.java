package fr.iagl.opl.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.iagl.opl.repository.ListRepository;

@Controller
public class WelcomeController {

	@Autowired
	private ListRepository listRepository;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", listRepository.findByName("work").getName());
		return "welcome";
	}

	public void setListRepository(ListRepository listRepository) {
		this.listRepository = listRepository;
	}
}