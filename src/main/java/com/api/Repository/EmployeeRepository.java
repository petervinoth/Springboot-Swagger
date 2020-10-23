package com.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	Employee findByEmail(String email);

	Employee deleteById(int id);

}
