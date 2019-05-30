package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.modal.Allocation;
import com.example.demo.modal.EmployeeAllocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Employee;
import com.example.demo.modal.Telephone;
import com.example.demo.repository.EmployeeRepository;
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
        if (optionalEmployee.isPresent()) {
            //fetch project allocation
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();

            //extract token from context
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
            httpHeaders.add("Authorization", "bearer ".concat(details.getTokenValue()));

            ResponseEntity<EmployeeAllocation> responseEntity;
            HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
            responseEntity = restTemplate.exchange("http://localhost:9090/emscloud/allocation/employee/".concat(employee.getId().toString()), HttpMethod.GET, entity, EmployeeAllocation.class);
            Employee employee1 = optionalEmployee.get();
//            System.out.println(responseEntity.getBody().getEmpId()+">>>>>>>>>");
            employee1.setAllocations(responseEntity.getBody());
            return employee1;
        } else {
            return null;
        }
    }
}
