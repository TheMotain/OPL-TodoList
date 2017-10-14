package fr.iagl.opl.repository;

import org.springframework.data.repository.CrudRepository;

import fr.iagl.opl.entity.List;

/**
 * Repository pour la récupération des objets List de la base de données
 * @author ALEX
 *
 */
public interface ListRepository extends CrudRepository<List, Long>{
	
	/**
	 * Récupère une liste par son nom
	 * @param name Nom à rechercher
	 * @return Liste récupérée, null si elle n'existe pas
	 */
	List findByName(String name);
}
