package emiage.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import emiage.validation.StudentCode;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="firstName")
	@NotNull(message="le prénom est requis")
	@Size(min=1, message="le prénom est requis")
	private String firstName;
	
	@Column(name="lastName")
	@NotNull(message="le nom est requis")
	@Size(min=1, message="le nom est requis")
	private String lastName;
	
	@Column(name="address")
	@NotNull(message="l'adresse est requise")
	@Size(min=1, message="l'adresse est requise")
	private String address;
	
	@Column(name="country")
	@NotNull(message="la nationalité est requise")
	private String country;
	
	@Column(name="email")
	@NotNull(message="Merci de donner votre email")
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message="la syntaxe n'est pas correcte")
	private String email;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="owner", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Property> owned_properties;
	
	
	public Person() {}


	public Person(String firstName, String lastName, String address, String country, String studentCode) {
		
		String FormattedSFN = firstName.toLowerCase();
		this.firstName = FormattedSFN.substring(0, 1).toUpperCase() + FormattedSFN.substring(1);
		
		String FormattedSLN = lastName.toLowerCase();
		this.lastName = FormattedSLN.substring(0, 1).toUpperCase() + FormattedSLN.substring(1);
		
		this.address = address;
		this.country = country;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Property> getOwned_properties() {
		return owned_properties;
	}


	public void setOwned_properties(List<Property> owned_properties) {
		this.owned_properties = owned_properties;
	}


	
	
}
