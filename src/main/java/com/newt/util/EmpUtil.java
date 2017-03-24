package com.newt.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmpUtil {

	public static ResponseEntity<?> getOK(Object obj) {
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<Object>(obj, HttpStatus.OK);
		return responseEntity;
	}

	public static ResponseEntity<?> getFailed(Object obj) {
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<Object>(obj, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

}
