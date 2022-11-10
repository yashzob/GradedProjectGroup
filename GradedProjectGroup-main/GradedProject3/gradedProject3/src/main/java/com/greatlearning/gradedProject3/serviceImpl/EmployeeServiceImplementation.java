package com.greatlearning.gradedProject3.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.gradedProject3.entity.Employee;
import com.greatlearning.gradedProject3.repository.EmployeeRepository;
import com.greatlearning.gradedProject3.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired EmployeeRepository employeeRepository;
	
	//This will return all employee
	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}
	//This will return an employee by ID 
	//only if it is available because "Optional" is mentioned
	@Override
	public Optional<Employee> findEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	
	//This will save a new employee 
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//This will delete a new employee with a given ID
	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return ;
		 
	}
	
	//Search By First Name
	@Override
	public List<Employee> searchByFirstName(String firstName) {
		return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName); 
	}
	//Sort by First Name in Asc order
	@Override
	public List<Employee> sortFirstNameAsc() {
		return employeeRepository.findAllByOrderByFirstNameAsc(); 
	}
	//Sort by First Name in Desc order
	@Override
	public List<Employee> sortFirstNameDesc() {
		return employeeRepository.findAllByOrderByFirstNameDesc(); 
	}
}
