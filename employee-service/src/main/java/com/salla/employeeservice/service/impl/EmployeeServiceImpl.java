package com.salla.employeeservice.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.salla.employeeservice.dto.APIResponseDto;
import com.salla.employeeservice.dto.DepartmentDto;
import com.salla.employeeservice.dto.EmployeeDto;

import com.salla.employeeservice.entity.Employee;
import com.salla.employeeservice.mapper.EmployeeMapper;
import com.salla.employeeservice.repository.EmployeeRepository;
import com.salla.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	// private RestTemplate restTemplate;

	private WebClient webClient;



	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		Employee saveDEmployee = employeeRepository.save(employee);

		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

		return savedEmployeeDto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();

		/*
		 * ResponseEntity<DepartmentDto> responseEntity=restTemplate
		 * .getForEntity("http://localhost:8080/api/departments/"+employee.
		 * getDepartmentCode() ,DepartmentDto.class); DepartmentDto
		 * departmentDto=responseEntity.getBody();
		 */

		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();

		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getEmail(), employee.getDepartmentCode());

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);

		return apiResponseDto;
	}

}
