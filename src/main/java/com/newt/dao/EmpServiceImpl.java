package com.newt.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newt.model.Employee;

@Component
@Transactional
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepository empRepo;
	
	public Employee getEmp(Long id) {
		return empRepo.findOne(id);
	}
	
	public void deleteEmployee(Long id) {
		empRepo.delete(empRepo.findOne(id));
	}
	
	public Employee addOrUpdateEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	public List<Employee> searchEmp(String keyword) {
		return empRepo.searchEmp(keyword.toLowerCase());
	}
}
