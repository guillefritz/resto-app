package ar.gmf.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import ar.gmf.dao.MenuDAO;
import ar.gmf.entities.Menu;

/**
 * Menu Service default Impl
 * 
 * @author guille
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	final MenuDAO menuDAO;

	@Autowired
	public MenuServiceImpl(MenuDAO menuDAO) {
		super();
		this.menuDAO = menuDAO;
	}

	@Override
	public Menu findById(Long id) {
		Assert.notNull(id, "Menu ID must not be null");
		return menuDAO.findById(id);
	}

	@Override
	public Collection<Menu> findAll() {
		return menuDAO.findAll();
	}

	@Override
	public <T> Map<T, List<Menu>> findAllGroupByT(Function<? super Menu, ? extends T> classifier) {
		Assert.notNull(classifier, "classifier must not be null");
		return menuDAO.findAll().stream().collect(Collectors.groupingBy(classifier));
	}
}
