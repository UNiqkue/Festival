package by.nik.traning.entity;

import by.nik.traning.EventException;

public class Event{

	private Long id;
	private String description;
	private String date;
	private String place;
	private Integer countPlace;
	private Integer countUser;

	public Event(){}

	public Event(Long id, String description, String date, String place, Integer countPlace, Integer countUser) {
		this.id = id;
		this.description = description;
		this.date = date;
		this.place = place;
		this.countPlace = countPlace;
		this.countUser = countUser;
	}

	public void addUser() throws EventException {
		countUser++;
	}

	public Integer getCountPlace() {
		return countPlace;
	}

	public void setCountPlace(Integer countPlace) {
		this.countPlace = countPlace;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public String getPlace() {
		return place;
	}

	public Integer getCountUser() {
		return countUser;
	}


}
