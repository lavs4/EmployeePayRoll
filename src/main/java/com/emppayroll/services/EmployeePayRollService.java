package com.emppayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emppayroll.dto.EmployeePayRollDTO;
import com.emppayroll.mappers.EmployeePayRollMapper;
import com.emppayroll.model.EmployeePayRollModel;

@Service
public class EmployeePayRollService {
	@Autowired
	private EmployeePayRollMapper mapper;
	public String getEmployee() {
		EmployeePayRollDTO dtomodel = mapper.dataToDto(new EmployeePayRollModel(1,"John",35000));
		return "Name : " +dtomodel.getName() + " Salary : "+dtomodel.getSalary();
	}
    public EmployeePayRollDTO createEmployee(EmployeePayRollDTO dto) {
        EmployeePayRollDTO response = mapper.dataToDto(new EmployeePayRollModel(dto.getId(),dto.getName(),dto.getSalary()));
        return response;
    }


}