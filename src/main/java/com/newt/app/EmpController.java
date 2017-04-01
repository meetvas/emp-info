package com.newt.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newt.dao.EmpService;
import com.newt.model.Employee;
import com.newt.util.EmpUtil;

@RestController
public class EmpController {
	
	public final Logger log =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmpService empService;
    
    @RequestMapping(value = "/getEmp", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEmployee(Long id) {
    	try {
    	  log.debug("Request Parameter Id: "+id);
    	  if(id==null)
    		  throw new Exception("User is needed !!!");
    	  Employee employee = empService.getEmp(id);
  	      if(employee==null)
  	    	  throw new Exception("User is not found !!!");
  	      log.debug("Employee: "+ employee);
  	      return EmpUtil.getOK(employee);
  	    } catch (Exception ex) {
  	      log.error("Exception: "+ex);
  	      return EmpUtil.getFailed(ex.getMessage());
  	    }
    }
    
    @RequestMapping(value = "/addOrUpdateEmp", method = RequestMethod.POST, produces = "application/json", consumes="application/json")
    public ResponseEntity<?> getEmpList(@RequestBody Employee emp) {
    	System.out.println("emp:"+emp);
    	System.out.println("emp first name:"+emp.getFirstName());
    	System.out.println("emp last name:"+emp.getLastName());
    	System.out.println("emp email:"+emp.getEmailId());
    	System.out.println("emp id:"+emp.getId());
    	empService.addOrUpdateEmployee(emp);
    	return EmpUtil.getOK(emp);
    }
    
    @RequestMapping(value = "/searchEmp", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEmpList(String keyword) {
    	List<Employee> empList = empService.searchEmp(keyword);
    	return EmpUtil.getOK(empList);
    }

}
