package dao.entity;

import dao.entity.abstracts.BaseEntity;
import dao.entity.enums.Role;
import exceptions.PhoneNumberException;

import javax.persistence.*;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String password;

	private String activationCode;

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
	@Enumerated(EnumType.STRING)
	private Set<Role> role;

	private String phoneNumber;

	private String cardNumber;

	public User(){ }

    public User(String firstName, String lastName, int age, String email, String password, String activationCode, String phoneNumber, String cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.activationCode = activationCode;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
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
			throw new PhoneNumberException("Invalid phone number");
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
}
