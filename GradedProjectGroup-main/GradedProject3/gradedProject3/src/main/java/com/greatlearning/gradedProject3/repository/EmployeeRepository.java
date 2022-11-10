package com.greatlearning.gradedProject3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.greatlearning.gradedProject3.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//Search By First Name
	List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);
	//Sort by First Name in Asc order
	List<Employee> findAllByOrderByFirstNameAsc();
	//Sort by First Name in Desc order
	List<Employee> findAllByOrderByFirstNameDesc();
	
	//THese above method are not defined in JPA repo, 
	//so we are defining here using camel cases required 
	//parameters are in small braces like (String firstName)
}
