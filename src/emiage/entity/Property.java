package emiage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="property", uniqueConstraints=@UniqueConstraint(columnNames="propertyAddress"))
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="l'adresse est requise")
	@Size(min=1, message="l'adresse est requise")
	@Column(name="propertyAddress", unique=true)
	private String propertyAddress;
	
	@NotNull(message="le code postal est requis")
	@Pattern(regexp="^[0-9]{5}", message="un code postal est composé de 5 chiffres")
	@Column(name="postalCode")
	private String postalCode;
	
	@NotNull(message="la nature est requise")
	@Column(name="nature")
	private String nature;
	
	@NotNull(message="la surface ne peut pas être nulle")
	@Min(value=1, message="la surface ne peut pas être nulle")
	@Column(name="surface")
	private Integer surface;
	
	@NotNull(message="le prix ne peut pas être nul")
	@Min(value=1, message="le prix ne peut pas être nul")
	@Max(value=500, message="les étudiants ne peuvent pas payer plus de 500€")
	@Column(name="price")
	private Integer price;
	
	private String propertyOptions;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="rented_property", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Person> renters;
	
	@NotNull(message="le bien doit avoir un propriétaire")
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id_owner")
	private Person owner;
	
	public Property() {}
	

	public Property(int id, String propertyAddress, String postalCode, String nature, Integer surface, Integer price, String propertyOptions) {
		this.id = id;
		this.propertyAddress = propertyAddress;
		this.postalCode = postalCode;
		this.nature = nature;
		this.surface = surface;
		this.price = price;
		this.propertyOptions = propertyOptions;
	}

	
	public String getPropertyAddress() {
		return propertyAddress;
	}


	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public Integer getSurface() {
		return surface;
	}


	public void setSurface(Integer surface) {
		this.surface = surface;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPropertyOptions() {
		return propertyOptions;
	}


	public void setPropertyOptions(String propertyOptions) {
		this.propertyOptions = propertyOptions;
	}


	public List<Person> getRenters() {
		return renters;
	}
	

	public void setRenters(List<Person> renters) {
		this.renters = renters;
	}
	
	
	public void add(Student renter) {
		
		if (renters == null) {
			renters = new ArrayList<>();
		}
		
		renters.add(renter);
		
		renter.setRented_property(this);
	}


	public Person getOwner() {
		return owner;
	}


	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	
	
}
