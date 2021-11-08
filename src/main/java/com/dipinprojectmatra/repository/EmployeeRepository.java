package com.dipinprojectmatra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipinprojectmatra.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
