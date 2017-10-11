package fr.iagl.opl.repository;

import org.springframework.data.repository.CrudRepository;

import fr.iagl.opl.entity.List;

public interface ListRepository extends CrudRepository<List, Long>{
	List findById(Long id);
}
