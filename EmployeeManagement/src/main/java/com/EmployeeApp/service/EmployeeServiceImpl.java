package com.EmployeeApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeApp.entity.Employee;
import com.EmployeeApp.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee emp) {
		Employee savedEmp = repo.save(emp);
		return savedEmp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmps = repo.findAll();
		return allEmps;
	}

	@Override
	public Employee getEmpById(Integer eid) {
		Optional<Employee> empById = repo.findById(eid);
		if(empById.isPresent()) {
			return empById.get();
		}
		return null;
	}

	@Override
	public void removeEmployee(Integer eid) {
		repo.deleteById(eid);
	}



	
	
}
