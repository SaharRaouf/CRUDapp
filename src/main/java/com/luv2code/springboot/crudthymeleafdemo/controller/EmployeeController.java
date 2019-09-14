package com.luv2code.springboot.crudthymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.crudthymeleafdemo.entity.Employee;
import com.luv2code.springboot.crudthymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

//Since we have on constructor autowired is optional
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/hello")
	public String sayhello(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());

		return "helloworld";
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		List<Employee> employees=employeeService.employeeList();
		theModel.addAttribute("theDate", new java.util.Date());
		theModel.addAttribute("theEmployees", employees);

		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormAddEmployee(Model theModel) {
		Employee newEmployee=new Employee();
		theModel.addAttribute("employee", newEmployee);
		return "employees/employee-form";
		
	}
	
	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("employee") Employee newEmployee) {
		
		employeeService.save(newEmployee);
		
		//use redirect to prevent duplicate submission
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormUpdateEmployee(@RequestParam("employeeId") int theId,Model theModel) {
		
		Employee theEmployee=employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
		
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		
		// Delete the employee
		employeeService.deleteById(theId);
		
		//use redirect to prevent duplicate submission
		return "redirect:/employees/list";
		
	}
	
}
