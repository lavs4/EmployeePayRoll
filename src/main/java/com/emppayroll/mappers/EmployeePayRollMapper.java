package com.emppayroll.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.emppayroll.dto.EmployeePayRollDTO;
import com.emppayroll.model.EmployeePayRollModel;

@Component
public class EmployeePayRollMapper {
	
	public EmployeePayRollDTO dataToDto(EmployeePayRollModel e) {
		EmployeePayRollDTO emp = new EmployeePayRollDTO(e.getId(),e.getSalary(),e.getName());
		return emp;
	}
	public EmployeePayRollModel DtoToData(EmployeePayRollDTO e) {
		EmployeePayRollModel emp = new EmployeePayRollModel();
		emp.setId(e.getId());
		emp.setName(e.getName());
		emp.setSalary(e.getSalary());
		return emp;
	}
	public List<EmployeePayRollDTO> listOfDataToDto(List<EmployeePayRollModel > e){
		return e.stream().map(x->dataToDto(x)).collect(Collectors.toList());
	}
	public List<EmployeePayRollModel> listOfDtoToData(List<EmployeePayRollDTO > e){
		return e.stream().map(y->DtoToData(y)).collect(Collectors.toList());
	}

}