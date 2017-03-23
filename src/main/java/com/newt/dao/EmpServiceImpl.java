package com.newt.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newt.model.Employee;

@Component
@Transactional
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao empDao;
	
	public Employee getEmp(Long id) {
		return empDao.findOne(id);
	}
}
