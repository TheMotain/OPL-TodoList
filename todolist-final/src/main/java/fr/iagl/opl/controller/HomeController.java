package fr.iagl.opl.controller;

import java.util.ArrayList;

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
	public String home(ModelMap model){
		java.util.List<List> todolists = new ArrayList<List>();
		listRepository.findAll().iterator().forEachRemaining(todolists::add);
		model.addAttribute(ModelAttributeEnum.TODOLISTS.getAttribute(), transformListsToDTO(todolists));
		model.addAttribute(ModelAttributeEnum.LIST_FORM.getAttribute(), new List());
		return PageEnum.HOME.getPage();
	}

	private java.util.List<ListDTO> transformListsToDTO(java.util.List<List> todolists) {
		java.util.List<ListDTO> output = new ArrayList<ListDTO>();
		for(List list : todolists){
			ListDTO dto = new ListDTO();
			dto.setName(list.getName());
			output.add(dto);
		}
		return output;
	}

	public void setListRepository(ListRepository listRepository) {
		this.listRepository = listRepository;
	}
}
