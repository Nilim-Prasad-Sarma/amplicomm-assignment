package com.te.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.employee.dto.EmployeeDto;
import com.te.employee.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;

	@PostMapping("/employee")
	public ResponseEntity<String> registerEmployeeAddress(@RequestBody EmployeeDto employee) {
		if (empService.registerEmp(employee) != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return null;
		}
	}

}
