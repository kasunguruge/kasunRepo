package com.example.demo.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Employee;


@RestController
@RequestMapping(value="/emscloud")
public class EmployeeController {

	
	@RequestMapping(value="/test")
	public Employee test(){
		
		
		Employee employee= new Employee();
		
		employee.setId(1);
		employee.setName("kasun");
		Address address=new Address();
		address.setId(1);
		address.setAddress1("Thissa");
		address.setCity("Debarawewa");
		employee.setAddress(address);
		return employee;
		
	}
	@RequestMapping(value="/test2")
public ResponseEntity<Employee> test2(){
		
	Integer x=2;
	
	if(x==null){
		Employee employee= new Employee();
		employee.setId(1);
		employee.setName("kasun");
		Address address=new Address();
		address.setId(1);
		address.setAddress1("Thissa");
		address.setCity("Debarawewa");
		employee.setAddress(address);
		return ResponseEntity.ok(employee);
	}
	else{
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("status", "invalid-status");
		return ResponseEntity.notFound().headers(httpHeaders).build();
	}
		
		
	}
}
