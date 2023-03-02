package com.salla.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salla.employeeservice.dto.APIResponseDto;
import com.salla.employeeservice.dto.EmployeeDto;
import com.salla.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployeeDto,HttpStatus.CREATED);
	}
	
//	@GetMapping("{id}")
//    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId)
//    {
//    	EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
//    	return new ResponseEntity<>(employeeDto, HttpStatus.OK);
//    }
	
	 @GetMapping("{id}")
	    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId)
	    {
	    	APIResponseDto apiResponseDto=employeeService.getEmployeeById(employeeId);
	    	return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	    }
	
}
