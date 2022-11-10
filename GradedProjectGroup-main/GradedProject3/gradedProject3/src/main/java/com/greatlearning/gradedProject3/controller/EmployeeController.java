package com.greatlearning.gradedProject3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.gradedProject3.entity.Employee;
import com.greatlearning.gradedProject3.entity.Role;
import com.greatlearning.gradedProject3.service.EmployeeService;
import com.greatlearning.gradedProject3.service.RoleService;
import com.greatlearning.gradedProject3.serviceImpl.EmployeeServiceImplementation;
import com.greatlearning.gradedProject3.serviceImpl.RoleServiceImplementation;

@RestController
@RequestMapping("/employeeManagement")

public class EmployeeController {

	@Autowired 
	EmployeeService employeeService; 
	
	
	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployees() {
		System.out.println("List of all Employee");
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee> theEmployee= employeeService.findEmployeeById(id);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		System.out.println("List of an Employee by id");
		return theEmployee;
	}
	//this will add an employee
	@PostMapping("/addEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		//employee.setEmployeeId(0);
		System.out.println("Adding an Employee...");
		return employeeService.saveEmployee(employee);
	}
	//this will update an employee
	@PutMapping("/editEmployee")
	public Employee editEmployee(@RequestBody Employee employee) {
		System.out.println("Updating an Employee...");
		return employeeService.saveEmployee(employee);
	}
	
	//this will delete an employee
	@DeleteMapping("/deleteEmployees/{id}")

	public String deleteEmployee(@PathVariable int id) {

		Optional<Employee> tempEmployee = employeeService.findEmployeeById(id);

		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}

		employeeService.deleteEmployee(id);
		System.out.println("Deleting an Employee...");
		return "Deleted employee id - " + id;
	}
	
	//Searching Employee list by firstName
	@GetMapping("/searchByFirstName/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName){
		System.out.println("Searching Employee list by "+firstName);
		return employeeService.searchByFirstName(firstName);
		
	}
	//Sorting Employee list by firstName in given order
	@GetMapping("/sortEmployees/order={order}")
	public List<Employee> sortEmployees(@PathVariable String order) {
		if(order.toString().equalsIgnoreCase("asc"))
			return employeeService.sortFirstNameAsc();
		if(order.toString().equalsIgnoreCase("desc"))
			return employeeService.sortFirstNameDesc();
		else
			throw new RuntimeException("Invalid Order"+ order); 
	}

}
