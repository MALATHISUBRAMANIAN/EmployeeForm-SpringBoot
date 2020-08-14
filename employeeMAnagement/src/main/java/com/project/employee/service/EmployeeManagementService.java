package com.project.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employee.model.Employee;
import com.project.employee.repository.EmployeeRepo;
import com.project.employee.repository.LoginRepo;

@Service
public class EmployeeManagementService {
	
	@Autowired
	EmployeeRepo repo;
	@Autowired
	LoginRepo loginrepo;
	
	/** insertEmployeeDetails is used to insert the employee details in the table
	 * 
	 * @param employee
	 */
	public void insertEmployeeDetails(Employee employee) {
		long id = loginrepo.findByMailid(employee.getMailid()).getId();
		employee.setEmpid(id);
		repo.save(employee);
	}
	
	/**
	 *  getEmployeeById is used to get particular employee by id
	 *  
	 * @param id
	 * @return id
	 */
	public Employee getEmployeeById(Long id) {
		return repo.findByEmpid(id);
	}

	/**
	 * updateEmployeeById is to update the particular employee by their id
	 * 
	 * @param id
	 * @param employee
	 */
	public void updateEmployeeById(long id, Employee employee) {
		Employee empObj = repo.findByEmpid(id);
		employee.setEmpid(empObj.getEmpid());
		repo.save(employee);
	}
}
