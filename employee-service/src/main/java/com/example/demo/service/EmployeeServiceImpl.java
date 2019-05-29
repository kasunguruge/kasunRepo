package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.modal.Allocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.modal.Employee;
import com.example.demo.modal.Telephone;
import org.springframework.web.client.RestTemplate;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		
		for (Telephone telephone : employee.getTelephones()) {
			telephone.setEmployee(employee);
		}
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee fetchEmployee(Employee employee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
		if(optionalEmployee.isPresent()) {

			RestTemplate restTemplate=new RestTemplate();
			HttpHeaders httpHeaders=new HttpHeaders();

			OAuth2AuthenticationDetails details=(OAuth2AuthenticationDetails)
					SecurityContextHolder.getContext().getAuthentication().getDetails();

			httpHeaders.add("Authorization" ,"bearer".concat(details.getTokenValue()));

			ResponseEntity<Allocation[]> responseEntity;

			HttpEntity<String> entity=new HttpEntity<>("",httpHeaders);

			responseEntity=restTemplate.exchange("http://localhost:9090/emscloud/getAllocation/".
					concat(employee.getId().toString()), HttpMethod.GET,entity,Allocation[].class);

			Employee employee1=optionalEmployee.get();

			employee1.setAllocation(responseEntity.getBody());
			return employee1;
		}
		else {
			return null;
		}
	}
}