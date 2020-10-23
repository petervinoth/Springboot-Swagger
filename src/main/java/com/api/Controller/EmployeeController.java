package com.api.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.api.DAO.EmployeeDao;
import com.api.Expection.ResourceNotFoundException;
import com.api.Model.Employee;
import com.api.Repository.EmployeeRepository;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/2kdev")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao Dao;
	
	@Autowired
	private EmployeeRepository repo;
	
	
	@PostMapping("/create")
	@ApiOperation(value = "store Employee Details api")

	public ResponseEntity<?> createemp(@Valid @RequestBody Employee employee){
		
		Employee exituser=repo.findByEmail(employee.getEmail());
		if(exituser!=null) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: email is already taken!"));
		
		}
		repo.save(employee);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		
	}
	
	@GetMapping("/employees")
	@ApiOperation(value = "getall Employee Details api")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> emp=Dao.findAll();
		return ResponseEntity.ok().body(emp);
			
	}
	
	@GetMapping("/employees/{id}")
	@ApiOperation(value = "select Employee Details api")
	public ResponseEntity<Optional<Employee>> getemployee(@PathVariable(value="id") int empid )throws ResourceNotFoundException{
		Optional<Employee> emp1=Dao.findById(empid);
		if(emp1==null) {
			return ResponseEntity.notFound().build();
			
		}
		return ResponseEntity.ok().body(emp1);
	}
		
	@PutMapping("/employees/{id}")
	@ApiOperation(value = "update Employee Details api")
	public ResponseEntity<Employee> putdetails(@PathVariable(value="id") int id,@Valid @RequestBody Employee emps)throws ResourceNotFoundException{
		Employee emp=Dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid student Id:" + id));
		emp.setName(emps.getName());
		emp.setAge(emps.getAge());
		emp.setEmail(emps.getEmail());
		emp.setDOB(emps.getDOB());
		emp.setCompanyName(emps.getCompanyName());
		emp.setCompanyLocation(emps.getCompanyLocation());
		emp.setAddress(emps.getAddress());
		emp.setDesignation(emps.getDesignation());
		emp.setExperience(emps.getExperience());
		emp.setPhoneno(emps.getPhoneno());
		emp.setSalary(emps.getSalary());
		final Employee updateemp=Dao.save(emp);
		return ResponseEntity.ok().body(emp);
		
		
	}
	
	@DeleteMapping("/employees/{id}")
	@ApiOperation(value = "remove Employee Details api")
	public ResponseEntity<?> remove(@PathVariable(value="id") int id)throws ResourceNotFoundException{
		
		Dao.delete(id);
		return ResponseEntity.ok(new MessageResponse("delete record  successfully!"));
		
		
		
		
	}
		
	}
	
	


