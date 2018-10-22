package by.nik.traning.dao.entity;

import by.nik.traning.dao.entity.abstracts.Event;
import by.nik.traning.dao.entity.abstracts.User;
import by.nik.traning.dao.entity.enums.TypeFestival;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Festival extends Event {

	private Long id;
	private String name;
	private String description;
	private Date date;
	private String place;
	private Long countPlace;
	private List<User> listOfUsers;
	private List<Performer> listOfPerformers;
	private double price;
	private Set<TypeFestival> type;

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public List<User> getListOfUsers() {
		return listOfUsers;
	}
	public void setListOfUsers(List<User> listOfUsers) {
		this.listOfUsers = listOfUsers;
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
	public Set<TypeFestival> getType() {
		return type;
	}
	public void setType(Set<TypeFestival> type) {
		this.type = type;
	}
}

   
    