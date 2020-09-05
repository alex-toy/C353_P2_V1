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

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="student")
public class Student extends Person {
	
	
	@Column(name="studentCode")
	@NotNull(message="le code étudiant doit commencer par MIAGE_")
	@StudentCode(value="MIAGE_", message="le code étudiant doit commencer par MIAGE_")
	private String studentCode;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id_rented_property")
	private Property rented_property;
	
	
	public Student() {}


	public Student(String studentCode) {
		super();
		this.studentCode = studentCode;
	}


	public String getStudentCode() {
		return studentCode;
	}


	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Property getRented_property() {
		return rented_property;
	}


	public void setRented_property(Property rented_property) {
		this.rented_property = rented_property;
	}



	
}
