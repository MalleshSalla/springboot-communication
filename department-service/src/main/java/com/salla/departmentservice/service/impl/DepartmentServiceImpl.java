package com.salla.departmentservice.service.impl;


import org.springframework.stereotype.Service;

import com.salla.departmentservice.dto.DepartmentDto;
import com.salla.departmentservice.entity.Department;
import com.salla.departmentservice.mapper.DepartmentMapper;
import com.salla.departmentservice.repository.DepartmentRepository;
import com.salla.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

	
@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		  // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
	}

	@Override
	public DepartmentDto findDepartmentByCode(String departmentCode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
	}
	

	  
}
