package com.emppayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emppayroll.dto.EmployeePayRollDTO;
import com.emppayroll.services.EmployeePayRollService;

@RestController
@RequestMapping("/employeepayservice")
public class EmployeeController {
	
	@Autowired
	private EmployeePayRollService eps;
	
	@GetMapping("/")
	public String getEmployeeData(){
		return eps.getEmployee();
	}
	@PostMapping("/create")
    public EmployeePayRollDTO createNewEmployee(@RequestBody EmployeePayRollDTO dto) {
        return eps.createEmployee(dto);
    }

}