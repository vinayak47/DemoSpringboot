package com.example.demo.dtos;

public class EmployeeRequest {
	
	@Override
	public String toString() {
		return "EmployeeRequest [name=" + name + ", salary=" + salary + "]";
	}

	private String name;
	
	private Double salary;
	
	public EmployeeRequest() {
		
		
	}

	public EmployeeRequest(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
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
	
	

}
