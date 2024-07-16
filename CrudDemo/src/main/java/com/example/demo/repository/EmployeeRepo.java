package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeProjection;
import com.example.demo.serviceImpl.EmployeeProjections;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	
	<T> List<T> findAllBy(Class<T> type);
	
	@Query(value = "SELECT * FROM employee WHERE name = :name OR salary = :salary", nativeQuery = true)
    List<Employee> findCustomNativeQuery(@Param("name") String name, @Param("salary") Double salary);

     Optional<Employee> findByName(String name);
     
    
     Page<EmployeeProjection> findAllProjectedBy(Pageable pageable);
}
