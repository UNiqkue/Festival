package by.nik.traning.dao.entity;

import by.nik.traning.dao.entity.abstracts.BaseEntity;
import by.nik.traning.dao.entity.enums.TypeEvent;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Festival extends BaseEntity {

	private String name;
	private String description;
	private Date date;
	private String place;
	private Long countPlace;
	private List<User> listOfUsers;
	private List<Performer> listOfPerformers;
	private double price;
	private Set<TypeEvent> type;

	public Festival(){}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCountPlace() {
		return countPlace;
	}
	public void setCountPlace(Long countPlace) {
		this.countPlace = countPlace;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public Date getDate() {
		return date;
	}
	public String getPlace() {
		return place;
	}
	public List<User> getListOfUsers() {
		return listOfUsers;
	}
	public void setListOfUsers(List<User> listOfUsers) {
		if (this.countPlace >= this.listOfUsers.size()) {
			this.listOfUsers = listOfUsers;
		}
	}
	public List<Performer> getListOfPerformers() {
		return listOfPerformers;
	}
	public void setListOfPerformers(List<Performer> listOfPerformers) {
		this.listOfPerformers = listOfPerformers;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Set<TypeEvent> getType() {
		return type;
	}

	public void setType(Set<TypeEvent> type) {
		this.type = type;
	}
}
