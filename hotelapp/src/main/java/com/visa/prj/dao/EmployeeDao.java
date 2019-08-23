package com.visa.prj.dao;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;

@Repository
public interface EmployeeDao {
	
	public void addEmployee(Employee e);
	
	public Employee getEmployeeById(String id);
		

}