package by.nik.traning.dao.entity;

import by.nik.traning.dao.entity.abstracts.BaseEntity;
import by.nik.traning.dao.entity.enums.Role;
import by.nik.traning.dao.exceptions.PhoneNumberException;

import java.sql.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends BaseEntity {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String activationCode;
	private Set<Role> role;
	private String phoneNumber;
	private int age;
	private long cardNumber;

	public User(){ }

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
			throw new PhoneNumberException("Invalid phone number");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
}
