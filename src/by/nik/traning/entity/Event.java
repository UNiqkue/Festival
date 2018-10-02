package by.nik.traning.entity;

public class Event{

	private Long id;
	private String description;
	private String date;
	private String place;
	private Integer countUser;

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
