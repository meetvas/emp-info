package com.newt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newt.model.Employee;

@Repository
public interface EmpRepository extends CrudRepository<Employee, Long> {
	@Query(value="select e.id, e.first_name, e.last_name, '' as emailid, '' as middle_name, '' as address from employee e where lower(e.first_name) like %:keyword% or lower(e.last_name) like %:keyword% or e.id like %:keyword%", nativeQuery=true)
	public List<Employee> searchEmp(@Param("keyword") String keyword);
}
