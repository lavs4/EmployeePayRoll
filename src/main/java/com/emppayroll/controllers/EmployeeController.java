package com.emppayroll.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<EmployeePayRollDTO> getEmployeeData(){
		return eps.getEmployee();
	}
	@GetMapping("/{id}")
	public EmployeePayRollDTO getEmployeeById(@PathVariable long id) {
		return eps.getEmployeeById(id);
	}
	@PostMapping("/create")
    public String createNewEmployee(@RequestBody EmployeePayRollDTO dto) {
        return eps.createEmployee(new EmployeePayRollDTO(dto.getId(),dto.getSalary(),dto.getName()));
    }
	
	@PutMapping("/update/{id}")
	public EmployeePayRollDTO updateEmployee(@PathVariable long id,@RequestBody EmployeePayRollDTO dto) {
		return eps.updateEmployee(id,new EmployeePayRollDTO(dto.getId(),dto.getSalary(),dto.getName()));
	}
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable long id) {
		eps.deleteEmployee(id);
	}

}