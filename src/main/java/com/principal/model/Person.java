package com.principal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity

public class Person {

	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	private String Name;
	private String Salary;

	 public Person()
	{

		
	}
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Person(String Name, String Salary) {
		this.Name = Name;
		this.Salary = Salary;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String Salary) {
		this.Salary = Salary;
	}

}
