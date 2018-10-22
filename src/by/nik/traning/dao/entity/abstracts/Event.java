package by.nik.traning.dao.entity.abstracts;

import by.nik.traning.dao.entity.Performer;

import java.util.Date;
import java.util.List;

public abstract class Event extends BaseEntity{

	private Long id;
	private String name;
	private String description;
	private Date date;
	private String place;
	private Long countPlace;
	private List<User> listOfUsers;
	private List<Performer> listOfPerformers;
	private double price;

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
	public void setId(Long id) {
		this.id = id;
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
	public Long getId() {
		return id;
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
}
