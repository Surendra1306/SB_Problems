package com.EmployeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeApp.entity.Employee;
import com.EmployeeApp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		List<Employee> allEmployees = service.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return "employees";
	}
	
	@GetMapping("/employees/newEmp")
	public String showEmpForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "saveEmp";
	}
	
	@PostMapping("/employees")
	public String createEmployee(Model model,@ModelAttribute("employee") Employee emp) {
		Employee savedEmployee = service.saveEmployee(emp);
		if(savedEmployee!=null) {
			model.addAttribute("succMsg", "Employee record added successfully..");
		}
		else {
			model.addAttribute("errMsg","Failed to add employee records..");
		}
		return "saveEmp";
	}
	
	@GetMapping("employees/update/{empId}")
	public String updateEmpById(@PathVariable("empId") Integer empId, Model model) {
		Employee empById = service.getEmpById(empId);
		model.addAttribute("editEmployee", empById);
		return "updateEmp";
	}
	
	@PostMapping("/employees/{empId}")
	public String updateEmployee(@PathVariable("empId") Integer empId
								,@ModelAttribute("editEmployee") Employee emp, Model model) {
		Employee existEmployee = service.getEmpById(empId);
		
		existEmployee.setId(empId);
		existEmployee.setName(emp.getName());
		existEmployee.setEmail(emp.getEmail());
		existEmployee.setPwd(emp.getPwd());
		existEmployee.setDob(emp.getDob());
		existEmployee.setAge(emp.getAge());
		existEmployee.setSalary(emp.getSalary());
		existEmployee.setStatus(emp.isStatus());
		Employee editedEmployee = service.saveEmployee(existEmployee);
		
		if(editedEmployee!=null) {
			model.addAttribute("succMsg", "Employee records updated successfully..");
		}
		else {
			model.addAttribute("errMsg","Failed to update employee records..");
		}
		
		return "updateEmp";
	}
	
	@GetMapping("/employees/delete/{eid}")
	public String deleteEmp(@PathVariable("eid") Integer eid) {
		service.removeEmployee(eid);
		return "redirect:/employees";
	}

}
