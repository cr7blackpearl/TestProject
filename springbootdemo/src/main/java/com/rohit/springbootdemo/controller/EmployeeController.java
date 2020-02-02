package com.rohit.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.springbootdemo.dao.PlyearsRepository;
import com.rohit.springbootdemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private PlyearsRepository plyearRepository;
	
	@GetMapping("/plyears")
	public List<Employee> getEmpoyees(){
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList.add(new Employee(1, "Cristiano", "Ronaldo", "cr7@gmail.com"));
		employeeList.add(new Employee(2, "Mesut", "Ozil", "ozil10@gmail.com"));
		employeeList.add(new Employee(3, "lionel", "Messi", "messi10@gmail.com"));
		employeeList.add(new Employee(4, "lionel", "Messi", "messi10@gmail.com"));
		employeeList.add(new Employee(5, "Neymar", "Jr.", "jr10@gmail.com"));
		
		return employeeList;
	}
	
	@PostMapping("/savePlyears")
	public Employee savePlyears(@RequestBody Employee emp) {
		Employee savedPlyear = plyearRepository.save(emp);

		return savedPlyear;
	}
	
	@GetMapping("/getAllPlyears")
	public List<Employee> getAllEmployee(){
		List<Employee> listOfPlyears = plyearRepository.findAll();
		
		return listOfPlyears;
	}
	
	@GetMapping("/getByLastName/{lastName}")
	public List<Employee> getEmployeeByLastName(@PathVariable String lastName){
		
		return plyearRepository.findByLastName(lastName);
	}
}
