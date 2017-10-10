package fr.iagl.opl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iagl.opl.dao.ListDAO;
import fr.iagl.opl.entity.ListEntity;
import fr.iagl.opl.entity.pk.ListPK;
import fr.iagl.opl.service.ListService;

@Service
@Transactional
public class ListServiceImpl implements ListService {
	
	@Autowired
	private ListDAO listDAO;
	
	@Override
	public ListEntity findById() {
		return listDAO.getByKey(new ListPK(1));
	}



	public void setListDAO(ListDAO listDAO) {
		this.listDAO = listDAO;
	}
	
	
}
