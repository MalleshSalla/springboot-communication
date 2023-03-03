package com.salla.employeeservice.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto 
{
	//This class is used to send department and employee details as Dto to the client after retrieving using rest template
	//Step 5:RestTemplate->create RestTemplate response class
	private EmployeeDto employee;
	private DepartmentDto department;
}