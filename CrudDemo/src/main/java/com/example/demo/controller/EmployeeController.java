package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.dtos.EmployeeRequest;
import com.example.demo.entity.Employee;
import com.example.demo.service.ApiResponse;
import com.example.demo.service.EmployeeProjection;
import com.example.demo.service.EmployeeService;
import com.example.demo.serviceImpl.EmployeeProjections;

@RestController
public class EmployeeController {
	
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addEmp")
	public ResponseEntity<ApiResponse>createEmployee(@RequestBody EmployeeDto employee){
		
		
		
		EmployeeDto createEmployee = this.service.createEmployee(employee);
		return  ResponseEntity.ok( new ApiResponse("employee created successfully",HttpStatus.CREATED,createEmployee));
		
		
	}

	@GetMapping("/getAllemp")
	public ResponseEntity<ApiResponse>getAllEmp(){
		
		
		
	 List<EmployeeProjection> allEmployee = this.service.getAllEmployee();
		return ResponseEntity.ok(new ApiResponse("get All Data of employee", HttpStatus.OK, allEmployee));
		
		
	}
	
	@PostMapping("/filterEmp")
	public ResponseEntity<ApiResponse>getEmployeeByNameAndSalary(@RequestBody EmployeeRequest request){
		
		
		// this.service.findEmployeesByNameAndSalary(request.getName(), request.getSalary());
		List<EmployeeProjections> findEmployeesByNameAndSalary = this.service.findEmployeesByNameAndSalary(request);
	
	      return ResponseEntity.ok(new ApiResponse("filter data of employee", HttpStatus.OK, findEmployeesByNameAndSalary));
	}
	
	@GetMapping("/getAllPageble")
	public ResponseEntity<ApiResponse>getAllEmpPageable(Pageable pageable){
		
		
		Page<EmployeeProjection> allDatawithPage = this.service.getAllDatawithPage(pageable);
	 //List<EmployeeProjection> allEmployee = this.service.getAllEmployee();
		return ResponseEntity.ok(new ApiResponse("get All Data of employee in page", HttpStatus.OK, allDatawithPage));
		
		
	}
}

