package com.newt.dao;

import java.util.List;

import com.newt.model.Employee;

public interface EmpService {
	public Employee getEmp(Long id);
	public void deleteEmployee(Long id);
	public Employee addOrUpdateEmployee(Employee emp);
	public List<Employee> searchEmp(String keyword);
}

