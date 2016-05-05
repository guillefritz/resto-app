package ar.gmf.dao;

import java.util.Collection;

import ar.gmf.entities.Menu;

/**
 * Menu DAO Interface
 * 
 * @author guille
 *
 */
public interface MenuDAO {

	/**
	 * Find a menu for the given ID
	 * @param id
	 * @return
	 */
	Menu findById(Long id);

	/**
	 * Find all the Menues
	 * @return
	 */
	Collection<Menu> findAll();
}
