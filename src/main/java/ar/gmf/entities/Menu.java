package ar.gmf.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class Menu {

	Long id;
	String name;
	Price price;
	LocalDate dateFrom;
	LocalDate dateTo;
	Integer ranking;
	LocalTime timeFrom;
	LocalTime timeTo;
	Collection<String> days = new ArrayList<>();

	public Menu() {
	}

	public Menu(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Menu(Long id, String name, Price price, LocalDate dateFrom, LocalDate dateTo, Integer ranking,
			LocalTime timeFrom, LocalTime timeTo, Collection<String> days) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.ranking = ranking;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.days = days;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public LocalTime getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(LocalTime timeFrom) {
		this.timeFrom = timeFrom;
	}

	public LocalTime getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(LocalTime timeTo) {
		this.timeTo = timeTo;
	}

	public Collection<String> getDays() {
		return days;
	}

	public void setDays(Collection<String> days) {
		this.days = days;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}

}
