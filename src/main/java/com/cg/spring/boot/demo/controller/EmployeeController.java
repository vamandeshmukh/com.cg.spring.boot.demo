package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

/**
 * 
 * @author Vaman
 *
 */

//mark class as Controller
@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3001/")
public class EmployeeController {

	// autowire the EmployeeService class
	@Autowired
	EmployeeService employeeService;

	Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

//creating a get mapping that retrieves all the Employee detail from the database
	@GetMapping("/getAllEmployees")
	private List<Employee> getAllEmployee() {
		LOG.info("getAllEmployees");
		return employeeService.getAllEmployee();
	}

	/**
	 * creating a get mapping that retrieves the detail of a specific Employee
	 * 
	 * @param id value for employee id to find
	 * @return Employee object based on the input Employees id
	 */

	@GetMapping("/getEmployee/{id}")
	private Employee getEmployee(@PathVariable("id") int id) {
		LOG.info("getEmployee " + id);
		return employeeService.getEmployeeById(id);
	}

//creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/deleteEmployee/{id}")
	private int deleteEmployee(@PathVariable("id") int id) {
		LOG.info("deleteEmployee " + id);
		return employeeService.delete(id);
	}

//creating post mapping that post the Employee detail in the database
	@PostMapping("/addEmployee")
	private Employee saveEmployee(@RequestBody Employee employee) {
		LOG.info("saveEmployee");
		return employeeService.saveOrUpdate(employee);
	}

//creating put mapping that updates the Employee detail
	@PutMapping("/updateEmployee")
	private Employee update(@RequestBody Employee Employee) {
		return employeeService.saveOrUpdate(Employee);
	}
}
