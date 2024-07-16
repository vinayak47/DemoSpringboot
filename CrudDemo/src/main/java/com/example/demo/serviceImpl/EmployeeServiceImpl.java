package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.dtos.EmployeeRequest;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DataException;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeProjection;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo repo;

	@Autowired
	ModelMapper modelMapper;
	
	
	 private final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	public EmployeeServiceImpl(EmployeeRepo repo, ModelMapper modelMapper) {
		this.repo = repo;
		this.modelMapper = modelMapper;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employee) {

		Employee map = this.modelMapper.map(employee, Employee.class);

		Optional<Employee> findByName = this.repo.findByName(employee.getName());

//		if (employee.getName().equals(map.getName())) {
//
//			// throw new Exception("this name already exist !!"+employee.getName());
//			throw new DataException("this name already exist !!" + map.getName());
//			// System.out.println("employee name already exist !");
//		} else {
//
//			Employee save = this.repo.save(map);
//
//			return this.modelMapper.map(save, EmployeeDto.class);
//		}
		if (findByName.isPresent()) {
			logger.error("this name already exist in db ");
			throw new DataException("this name already exist !!" + employee.getName());
			
		} else {

			Employee save = this.repo.save(map);
			logger.info("employee saved successfully with name is :"+employee.getName(), save);
			
			return this.modelMapper.map(save, EmployeeDto.class);
		}

	}

	@Override
	public List<EmployeeProjection> getAllEmployee() {
		List<EmployeeProjection> findAllBy = this.repo.findAllBy(EmployeeProjection.class);
		return findAllBy;
	}

	@Override
	public List<EmployeeProjections> findEmployeesByNameAndSalary(EmployeeRequest request) {
		List<Employee> employees = this.repo.findCustomNativeQuery(request.getName(), request.getSalary());

		if (employees.isEmpty()) {

			throw new DataException("data not found");
		}
		// return
		// employees.stream().map(this::convertToProjection).collect(Collectors.toList());

		return employees.stream().map(x -> modelMapper.map(x, EmployeeProjections.class)).collect(Collectors.toList());

		

	}

	@Override
	public Page<EmployeeProjection> getAllDatawithPage(Pageable pageable) {
		return repo.findAllProjectedBy(pageable);
		
//		Page<Employee> findAll = this.repo.findAll(pageable);
//		 Page<EmployeeProjection> collect = findAll.stream().map(x->EmployeeProjection.class).collect(Collectors.toList());
//		//return collect;
//		return collect;
		
		
		
		
	}

//	private EmployeeProjections convertToProjection(Employee employee) {
//		return modelMapper.map(employee, EmployeeProjections.class);
////        EmployeeProjections projection = new EmployeeProjections();
////        projection.setName(employee.getName());
////        projection.setSalary(employee.getSalary());
////        // Set other fields as needed
////
////        return projection;
//		
//	
//}
}
