package com.emppayroll.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emppayroll.dto.EmployeePayRollDTO;
import com.emppayroll.mappers.EmployeePayRollMapper;
import com.emppayroll.model.EmployeePayRollModel;

@Service
public class EmployeePayRollService {
	@Autowired
	private EmployeePayRollMapper mapper;
	
	List<EmployeePayRollModel> employeelist = new ArrayList<>(); 
	
	public List<EmployeePayRollDTO> getEmployee(){
		return employeelist.stream().map(x->mapper.dataToDto(x)).collect(Collectors.toList());
	}
	public EmployeePayRollDTO getEmployeeById(long id) {
		try {
			for(int i=0;i<employeelist.size();i++) {
				if(employeelist.get(i).getId()==id) {
					return mapper.dataToDto(employeelist.get(i));
				}
			}
		}
		catch(Exception e) {
			System.out.println("EMPLOYEE NOT FOUND");
		}
		return null;
	}
	
	public String createEmployee(EmployeePayRollDTO d) {
		employeelist.add(mapper.DtoToData(d));
		return "Successfully added " + d.getName() + "to the list";
	}
	public EmployeePayRollDTO updateEmployee(long id,EmployeePayRollDTO emp) {
		for (EmployeePayRollModel e : employeelist) {
	        if (e.getId() == id) {
	            e.setName(emp.getName());
	            e.setSalary(emp.getSalary());
	            return mapper.dataToDto(e); 
	        }
	    }
	    return null; 
	}
    public void deleteEmployee(long id) {
    	try {
    		for (EmployeePayRollModel e : employeelist) {
    	        if (e.getId() == id) {
    	            employeelist.remove(e);
    	            return ;
    	        }
    	    }
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

}