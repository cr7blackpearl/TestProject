package com.rohit.springbootdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.springbootdemo.entity.Employee;


public interface PlyearsRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByLastName(String lastName);
	
	

}
