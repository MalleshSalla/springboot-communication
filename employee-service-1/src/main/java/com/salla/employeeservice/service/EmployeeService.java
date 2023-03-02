package com.salla.employeeservice.service;

import com.salla.employeeservice.dto.APIResponseDto;
import com.salla.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	 APIResponseDto getEmployeeById(Long employeeId);

}
