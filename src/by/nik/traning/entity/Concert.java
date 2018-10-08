package by.nik.traning.entity;

import by.nik.traning.EventException;

public class Concert extends Event {

    private Long id;
    private String description;
    private String date;
    private String place;
	private Integer countPlace;
    private Integer countUser;

    public Concert(){}

	public Concert(Long id, String description, String date, String place, Integer countPlace, Integer countUser) {
		super(id, description, date, place, countPlace, countUser);
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Integer getCountUser() {
		return countUser;
	}
	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}
	
}

   