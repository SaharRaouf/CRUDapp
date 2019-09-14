package com.luv2code.springboot.crudthymeleafdemo.service;



	import java.util.List;

import com.luv2code.springboot.crudthymeleafdemo.entity.Employee;


	public interface EmployeeService {

	public	List<Employee> employeeList();

	public Employee findById(Integer theId);

	public void save(Employee employee);

	public void deleteById(Integer theId);
	}
