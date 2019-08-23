package com.visa.prj.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addEmployee(Employee e) {
		em.persist(e);

	}

	@Override
	public Employee getEmployeeById(String id) {
		return em.find(Employee.class, id);
	}


}
