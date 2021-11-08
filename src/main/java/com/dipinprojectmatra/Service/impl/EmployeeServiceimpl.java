package com.dipinprojectmatra.Service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.dipinprojectmatra.Service.EmployeeService;
import com.dipinprojectmatra.entity.Employee;
import com.dipinprojectmatra.repository.EmployeeRepository;

@Service
public class EmployeeServiceimpl implements EmployeeService{
	private EmployeeRepository employeeRepository;
	
public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


@Override
public List<Employee> getAllEmployee(){
	return employeeRepository.findAll();
}
@Override
public Employee saveEmployee (Employee employee) {
	return employeeRepository.save(employee);
}
@Override
public Employee getEmployeeById(Long id) {
	return employeeRepository.findById(id).get();
}

@Override
public Employee updateEmployee(Employee employee) {
	return employeeRepository.save(employee);
}

@Override
public void deleteEmployeeById(Long id) {
	employeeRepository.deleteById(id);
}

}
