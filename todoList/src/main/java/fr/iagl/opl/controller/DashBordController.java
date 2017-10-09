package fr.iagl.opl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DashBordController {

	@Autowired
	private ListService listService;
}
