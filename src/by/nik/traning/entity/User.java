package by.nik.traning.entity;

import by.nik.traning.exceptions.PhoneNumberException;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User{
	
	private Integer id;
	private String firstName;
	private String lastName;
	private int age;
	private Set<Role> role;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;

	public User(){}

	public User(Integer id, String firstName, String lastName, int age, Set<Role> role, String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.role = role;
		this.phoneNumber = phoneNumber;
	}

	public void verifyPhoneNumber(String phoneNumber) throws PhoneNumberException {
		Pattern pattern = Pattern.compile("((80|\\+375)[\\s|-]?(29|25|33|44))[\\s|-]?(\\d{7}|\\d{3}[\\s|-]?\\d{2}[\\s|-]?\\d{2})");
		Matcher matcher = pattern.matcher(phoneNumber);
		/*boolean bl = matcher.find();
		System.out.println(bl);
		if(!bl){
			throw new PhoneNumberException("No any symbol");
		}*/
		//System.out.println(matcher.group());
		boolean bl = matcher.matches();
		System.out.println(bl);
		if(!bl){
			throw new PhoneNumberException("Match not found");
		}
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public Set<Role> getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
