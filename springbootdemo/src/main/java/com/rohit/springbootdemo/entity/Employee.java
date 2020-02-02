package com.rohit.springbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	public Employee() {
		
	}
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	public Employee(Integer id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
	
	  public Integer getId() { return id; }
	  
	  
	  public void setId(Integer id) { this.id = id; }
	  
	  
	  public String getFirstName() { return firstName; }
	  
	  
	  public void setFirstName(String firstName) { this.firstName = firstName; }
	  
	  
	  public String getLastName() { return lastName; }
	  
	  
	  public void setLastName(String lastName) { this.lastName = lastName; }
	  
	  
	  public String getEmail() { return email; }
	  
	  
	  public void setEmail(String email) { this.email = email; }
	 	  
	  @Override public String toString() { return "Employee [id=" + id +
	  ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email +
	  "]"; }
}
