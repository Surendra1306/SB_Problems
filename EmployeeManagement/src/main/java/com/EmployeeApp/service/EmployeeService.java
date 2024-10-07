package com.EmployeeApp.service;

import java.util.List;

import com.EmployeeApp.entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmpById(Integer eid);
		
	public void removeEmployee(Integer eid);

}
