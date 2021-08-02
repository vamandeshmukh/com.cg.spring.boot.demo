package com.cg.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

//defining the business logic
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

//getting all Employee record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployee() {
		List<Employee> employee = new ArrayList<Employee>();
//		employee.add(new Employee(101, "Sonu", 10.5));
//		employee.add(new Employee(102, "Monu", 20.5));
//		employee.add(new Employee(103, "Tonu", 15.5));
		employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
		return employee;
	}

//getting a specific record by using the method findById() of CrudRepository
	public Employee getEmployeeById(int id) {
//		return new Employee(101, "Sonu", 10.5);
		return employeeRepository.findById(id).get();
	}

//saving a specific record by using the method save() of CrudRepository
	public Employee saveOrUpdate(Employee employee) {
		return employeeRepository.save(employee);
	}

//deleting a specific record by using the method deleteById() of CrudRepository
	public int delete(int id) {
		employeeRepository.deleteById(id);
		return id;
	}

//updating a record
	public Employee update(Employee employee, int eid) {
		return employeeRepository.save(employee);
	}

}
