package com.api.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.Model.Employee;
import com.api.Repository.EmployeeRepository;



@Service
public class EmployeeDao {
	
	@Autowired
    EmployeeRepository repo;
	
	public Employee save(Employee emp) {
		return repo.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<Employee> findAll(){
		return repo.findAll();
	}
	
	
	/*get an employee by id*/
	public Optional<Employee> findById(int empid) {
		return repo.findById(empid);
	}
	
	
	/*delete an employee*/
	
	public void delete(@PathVariable int id) {
		repo.deleteById(id);
	}


	
	

}
