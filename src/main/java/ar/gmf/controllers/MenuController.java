package ar.gmf.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.gmf.entities.Menu;
import ar.gmf.entities.Price;
import ar.gmf.services.MenuService;

@Controller
public class MenuController {

	@Autowired
	MenuService menuService;

	@RequestMapping("/menu/{id}/")
	@ResponseBody
	public Menu findById(@PathVariable Long id) {
		return menuService.findById(id);
	}

	@RequestMapping("/menu/")
	@ResponseBody
	public Collection<Menu> findAll() {
		return menuService.findAll();
	}
	
	@RequestMapping("/menuGroupByPrice/")
	@ResponseBody
	public Map<Price, List<Menu>> findAllGroupByPrice() {
		return menuService.findAllGroupByT(Menu::getPrice);
	}
}
