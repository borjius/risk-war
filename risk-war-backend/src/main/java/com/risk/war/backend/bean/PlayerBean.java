package com.risk.war.backend.bean;

public class PlayerBean {
	
	private String name;
	private String surname;
	private String country;
	private Position position;
	private int value;
	private int contract;
	private int contractYears;
	private int salary;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getContract() {
		return contract;
	}
	public void setContract(int contract) {
		this.contract = contract;
	}
	public int getContractYears() {
		return contractYears;
	}
	public void setContractYears(int contractYears) {
		this.contractYears = contractYears;
	}
	@Override
	public String toString() {
		return "name=" + name + " " + surname
				+ ", country=" + country + ", position=" + position
				+ ", value=" + value + ", contract=" + contract
				+ ", contractYears=" + contractYears + ", salary=" + salary
				+ ", age=" + age + "]";
	}
	
	

}
