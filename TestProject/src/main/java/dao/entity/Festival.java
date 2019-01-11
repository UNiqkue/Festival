package dao.entity;

import dao.entity.abstracts.BaseEntity;
import dao.entity.enums.TypeEvent;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/*@Entity
@Table(name = "fest")*/
public class Festival extends BaseEntity {

/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private Long id;
//	@Column(name = "name")
	private String name;
	private String description;
	private int countPlace;
	private double price;

/*	@ElementCollection(targetClass = TypeEvent.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "fest_type", joinColumns = @JoinColumn(name = "fest_id"))
	@Enumerated(EnumType.STRING)*/
	private Set<TypeEvent> type;
	private List<User> listOfUsers;
	private List<Performer> listOfPerformers;

	public Festival(){ }

	public Festival(String name, String description, int countPlace, double price) {
		this.name = name;
		this.description = description;
		this.countPlace = countPlace;
		this.price = price;
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
	public int getCountPlace() {
		return countPlace;
	}
	public void setCountPlace(int countPlace) {
		this.countPlace = countPlace;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
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
