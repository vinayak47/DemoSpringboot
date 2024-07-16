package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.dtos.EmployeeRequest;
import com.example.demo.serviceImpl.EmployeeProjections;

public interface EmployeeService {

	//SAVE EMPLOYEE
	EmployeeDto createEmployee(EmployeeDto employee);
	
	//GET LIST OF ALL EMPLOYEE ON SPECIFIC FIELD
	List<EmployeeProjection> getAllEmployee();
	
	//filter EMPLOYEE
	List<EmployeeProjections> findEmployeesByNameAndSalary(EmployeeRequest request);
		
	Page<EmployeeProjection> getAllDatawithPage(Pageable pageable);
		
		
	
	
}
