package com.example.demo.serviceImpl;

public class EmployeeProjections {
	private Integer Id;
	private String name;
	private Double salary;


	public EmployeeProjections(Integer id, String name, Double salary) {
		super();
		Id = id;
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	
	public EmployeeProjections() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public EmployeeProjections(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeProjections [Id=" + Id + ", name=" + name + ", salary=" + salary + "]";
	}

}
