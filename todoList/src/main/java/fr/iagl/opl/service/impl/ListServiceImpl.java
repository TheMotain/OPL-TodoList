package fr.iagl.opl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iagl.opl.dao.ListDAO;
import fr.iagl.opl.service.ListService;

@Service("listService")
@Transactional
public class ListServiceImpl implements ListService {
	
	@Autowired
	private ListDAO listDAO;
}
