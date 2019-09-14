package com.luv2code.springboot.crudthymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.crudthymeleafdemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//
	//no neead for defiing DAO OR IMPLDAO
	
	// sort the data
	//order by last name ascending
	//Spring data JPA will parse the methodname
	//Behind the scen
	//from Employee order by lastName asc
	public List<Employee> findAllByOrderByLastNameAsc();
}
