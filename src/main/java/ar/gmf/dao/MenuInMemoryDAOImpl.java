package ar.gmf.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Currency;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import ar.gmf.entities.Menu;
import ar.gmf.entities.Price;

/**
 * In memory DAO implementation
 * 
 * @author guille
 *
 */
@Repository
public class MenuInMemoryDAOImpl implements MenuDAO {
	
	/*
	 * mock collection
	 */
	Collection<Menu> menues = new ArrayList<>();

	public MenuInMemoryDAOImpl() {
	}

	/*
	 * After spring beans build, maybe for using some othe bean. Could be done in class constructor too.
	 */
	@PostConstruct
	public void setup() {
		menues.add(new Menu(1l,  "Dinner 1",     new Price(Currency.getInstance("EUR"), new BigDecimal(100)), LocalDate.of(2016, 2, 10), LocalDate.of(2016, 2, 20), 4, LocalTime.of(20, 0), LocalTime.of(23, 30), Arrays.asList("mon","tue") ));
		menues.add(new Menu(2l,  "Lunch 2",    new Price(Currency.getInstance("EUR"), new BigDecimal(40)),  LocalDate.of(2016, 3, 5),  LocalDate.of(2016, 3, 15), 3, LocalTime.of(12, 0), LocalTime.of(15, 0), Arrays.asList("tue","wed")));
		menues.add(new Menu(3l,  "Lunch 4",   new Price(Currency.getInstance("USD"), new BigDecimal(60)),  LocalDate.of(2016, 2, 20), LocalDate.of(2016, 3, 10), 5, LocalTime.of(12, 0), LocalTime.of(15, 0), Arrays.asList("sun","mon")));
		menues.add(new Menu(10l, "Dinner 5", new Price(Currency.getInstance("ARS"), new BigDecimal(100)), LocalDate.of(2016, 2, 4),  LocalDate.of(2016, 2, 25), 2, LocalTime.of(20, 30), LocalTime.of(23, 30), Arrays.asList("sun","sat")));
		menues.add(new Menu(15l, "Dinner 6",   new Price(Currency.getInstance("ARS"), new BigDecimal(50)),  LocalDate.of(2016, 3, 7),  LocalDate.of(2016, 3, 18), 4, LocalTime.of(21, 0), LocalTime.of(23, 50), Arrays.asList("mon","tue","wed")));
		menues.add(new Menu(16l, "Dinner 8",   new Price(Currency.getInstance("USD"), new BigDecimal(40)),  LocalDate.of(2016, 2, 1),  LocalDate.of(2016, 2, 12), 3, LocalTime.of(20, 0), LocalTime.of(23, 0), Arrays.asList("wed","thu","fri")));
		menues.add(new Menu(19l, "Lunch 5",    new Price(Currency.getInstance("USD"), new BigDecimal(60)),  LocalDate.of(2016, 2, 27), LocalDate.of(2016, 3, 9),  5, LocalTime.of(10, 0), LocalTime.of(14, 0), Arrays.asList("fri","sat")));
		menues.add(new Menu(20l, "Dinner 9",   new Price(Currency.getInstance("EUR"), new BigDecimal(50)),  LocalDate.of(2016, 2, 6),  LocalDate.of(2016, 2, 26), 1, LocalTime.of(20, 0), LocalTime.of(23, 15), Arrays.asList("fri","sat","sun")));
	}

	@Override
	public Menu findById(Long id) {
		Assert.notNull(id, "Menu ID must not be null");
		return menues.stream().filter(m -> m.getId().equals(id)).findAny().orElse(null);
	}

	@Override
	public Collection<Menu> findAll() {
		return menues;
	}

}
