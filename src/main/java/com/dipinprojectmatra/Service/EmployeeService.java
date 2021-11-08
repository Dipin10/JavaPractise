package com.dipinprojectmatra.Service;
import java.util.List;

import com.dipinprojectmatra.entity.Employee;

public interface EmployeeService {
             List<Employee> getAllEmployee();
	
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee employee);
	void deleteEmployeeById(Long id);

	
	}