package com.salla.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salla.departmentservice.dto.DepartmentDto;
import com.salla.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		
	DepartmentDto savedDepartmentDto = 	departmentService.saveDepartment(departmentDto);
		
		return new ResponseEntity<>(savedDepartmentDto,HttpStatus.CREATED);
	}
	
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> findDepartment(@PathVariable("department-code") String departmentCode){
		DepartmentDto departmentDto = departmentService.findDepartmentByCode(departmentCode);
		
		return new ResponseEntity<>(departmentDto,HttpStatus.OK); 
	}
	
	

}
