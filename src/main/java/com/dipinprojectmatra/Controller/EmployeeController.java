package com.dipinprojectmatra.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dipinprojectmatra.Service.EmployeeService;
import com.dipinprojectmatra.entity.Employee;

@RestController
@RequestMapping("/api/me")
public class EmployeeController {
private EmployeeService employeeService;

public EmployeeController(EmployeeService employeeservice) {
	super();
	this.employeeService = employeeservice;
}
//handler method vanni aba list students wala ko lagi
@GetMapping("/employee")
public String listEmployee(Model model) {
	model.addAttribute("employee",employeeService.getAllEmployee());
	return "employee";
}
@GetMapping("/employee/new")
public String createEmployeeForm(Model model) {
	Employee employee=new Employee();
	model.addAttribute("employee",employee);
	return "create_employee";
}
@PostMapping("/employee")
public String saveEmployee(@RequestBody Employee employee) {
	employeeService.saveEmployee(employee);
	return"redirect:/employee";
}
@GetMapping("/employee/edit/{id}")
public String editEmployeeForm(@PathVariable Long id,Model model) {
	model.addAttribute("employee",employeeService.getEmployeeById(id));
	
return "edit_employee";
}
@PutMapping("/employee/{id}")
public String updateEmployee(@PathVariable Long id,
		@RequestBody Employee employee,Model model) {
//aba database bata launi
	Employee existingEmployee=employeeService.getEmployeeById(id);
	System.out.println("existing employee "+existingEmployee.getId());
	existingEmployee.setId(id);
	existingEmployee.setFirstName(employee.getFirstName());
	existingEmployee.setLastName(employee.getLastName());
	existingEmployee.setEmail(employee.getEmail());
	//aba aslai update garni
employeeService.updateEmployee(existingEmployee);
return "redirect:/employee";
	
}
//aba delete ko lagi
@DeleteMapping("/employee/{id}")
public String deleteEmployee(@PathVariable Long id) {
	employeeService.deleteEmployeeById(id);
	return"redirect:/employee";
}

}
