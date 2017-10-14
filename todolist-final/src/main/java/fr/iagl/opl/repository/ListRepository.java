package fr.iagl.opl.repository;

import org.springframework.data.repository.CrudRepository;

import fr.iagl.opl.entity.List;

public interface ListRepository extends CrudRepository<List, Long>{
	List findByName(String name);
	java.util.List<List> findAll();
}
