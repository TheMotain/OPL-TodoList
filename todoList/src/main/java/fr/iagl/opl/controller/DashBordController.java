package fr.iagl.opl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.iagl.opl.service.ListService;

@Controller
public class DashBordController {

	@Autowired
	private ListService listService;
}
