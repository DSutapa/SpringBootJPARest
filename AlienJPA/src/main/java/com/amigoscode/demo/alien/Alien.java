package com.amigoscode.demo.alien;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Alien {
	
	@Id
	@SequenceGenerator(name="a_seq", 
					   sequenceName="a_seq", 
					   allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
					generator="a_seq")
	private long id;
	private String name;
	private String email;
	private LocalDate dob;
	private int age;
	public Alien(long id, String name, String email, LocalDate dob, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	public Alien(String name, String email, LocalDate dob, int age) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	public Alien(long id) {
		super();
		this.id = id;
	}
	public Alien() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		return Period.between(this.getDob(), LocalDate.now()).getYears();
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}
	
	

}
