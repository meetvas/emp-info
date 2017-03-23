package com.newt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newt.model.Employee;

@Repository
public interface EmpDao extends CrudRepository<Employee, Long> {
}
