package ar.gmf.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import ar.gmf.entities.Menu;

/**
 * Menu Service interface
 * @author guille
 *
 */
public interface MenuService {

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

	/**
	 * Find all the menues generically grouping by the given classifier, examples: Menu::getPrice or Menu::getRanking 
	 * @param classifier
	 * @return
	 */
	<T> Map<T, List<Menu>> findAllGroupByT(Function<? super Menu, ? extends T> classifier);
}
