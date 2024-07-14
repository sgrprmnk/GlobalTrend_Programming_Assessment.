package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.LogRequest;
import com.example.demo.annotation.LogResponse;
import com.example.demo.annotation.LogTime;
import com.example.demo.dto.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/")
	@LogTime
	public String getEmployee() throws InterruptedException {
		Thread.sleep(5000);
		return "Raj";
	}
	
	@GetMapping("/employee/{id}")
	@LogRequest
	@LogResponse
	public Employee getEmployeeById(@PathVariable("id") String id) {
		return new Employee("Raj",Integer.parseInt(id));
	}
}
