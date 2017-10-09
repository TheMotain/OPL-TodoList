package fr.iagl.opl.dao.impl;

import org.springframework.stereotype.Repository;

import fr.iagl.opl.dao.AbstractDAO;
import fr.iagl.opl.dao.ListDAO;
import fr.iagl.opl.entity.ListEntity;
import fr.iagl.opl.entity.pk.ListPK;

@Repository("listDAO")
public class ListDAOImpl extends AbstractDAO<ListEntity, ListPK> implements ListDAO {

}
