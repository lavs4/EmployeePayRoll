package com.emppayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emppayroll.dto.EmployeePayRollDTO;
import com.emppayroll.mappers.EmployeePayRollMapper;
import com.emppayroll.model.EmployeePayRollModel;

@RestController
@RequestMapping("/employeepayservice")
public class EmployeeController {
	
	@Autowired
	private EmployeePayRollMapper epm;
	
	@GetMapping("/")
	public String getEmployee(){
		 EmployeePayRollModel e = new EmployeePayRollModel(1,"John",50000);
		 EmployeePayRollDTO emp= epm.dataToDto(e);
		 return "Name : " + emp.getName()+ " Salary : " + emp.getSalary();
	}
	@PostMapping("/create")
    public EmployeePayRollDTO createEmployee(@RequestBody EmployeePayRollDTO dto) {
        EmployeePayRollDTO response = epm.dataToDto(epm.DtoToData(dto));
        return response;
    }

}