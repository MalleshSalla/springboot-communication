package com.salla.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salla.employeeservice.dto.DepartmentDto;




/*Step 2:FeignClient->cteate interface and annotate with @FeignClient and add method signature of the method from which method we will get department details i.e Get Rest api
@FeignClient(url="http://localhost:8080",value="DEPARTMENT-SERVICE")*/

/*Spring cloud default load balancing
 *department-service consisting of 2 port numbers(8080,8082) if one port is down feign client retrieve data from department service using another port number.
 *This is done by using default load balancer which is provided by eureka client dependency. 
 * */
@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient 
{
	//We don't need to create implementation for this method because FeignClient will implement the method dynamically 
	@GetMapping("api/departments/{department-code}")
	DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}