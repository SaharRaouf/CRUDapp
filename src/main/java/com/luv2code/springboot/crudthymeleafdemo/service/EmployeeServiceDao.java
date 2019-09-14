package com.luv2code.springboot.crudthymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.crudthymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.crudthymeleafdemo.entity.Employee;


@Service
public class EmployeeServiceDao implements EmployeeService {

	private EmployeeRepository employeeRepo;

	// Removing @Transactional since JpaRepository provides this functionality

	@Autowired
	public EmployeeServiceDao(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	
	

	@Override
	public List<Employee> employeeList() {

		return employeeRepo.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(Integer theId) {
		// checkId
		Optional<Employee> result = employeeRepo.findById(theId);

		Employee employee = null;
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Employee not found." + theId);
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public void deleteById(Integer theId) {
		employeeRepo.deleteById(theId);

	}

}
