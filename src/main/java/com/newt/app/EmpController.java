package com.newt.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newt.dao.EmpService;
import com.newt.model.Employee;

@RestController
public class EmpController {
	
	public final Logger log =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmpService empService;
	
    @RequestMapping("/")
    public String home() throws Exception {
    	try {
    	      Employee employee = empService.getEmp(1l);
    	      log.debug("employee:"+employee);
    	      return String.valueOf(employee.getFirstName());
    	    }
    	    catch (Exception ex) {
    	      log.error("exception ex"+ex);
    	      return "User not found";
    	    }
    }

}
