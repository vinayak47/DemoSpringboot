package com.example.demo.dtos;

public class EmployeeFilterRequest {
	
	private String name;
	
	private Double salary;
	
	public EmployeeFilterRequest() {
		
		
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

	public EmployeeFilterRequest(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeFilterRequest [name=" + name + ", salary=" + salary + "]";
	}
	
	

}
