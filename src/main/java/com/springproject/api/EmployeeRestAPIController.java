package com.springproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springproject.model.Employee;
import com.springproject.service.EmployeeService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info = @Info(title = "Employee REST API", version ="5.0", description = "employee CRUD APIs"))
public class EmployeeRestAPIController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/api/emp/list")
	public List<Employee>  getAllEmp(){
		
		
		return empService.getAllEmp();
	}
	
	@GetMapping("/api/emp/{id}")
	public Employee getempbyid(@PathVariable Long id) {
		
		
		return empService.getEmpById(id);
	}
	
	@PostMapping("/api/emp/add")
	public String add(@RequestBody Employee emp) {
		
		empService.addEmp(emp);
		
		return  "added successfully";
	}
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee emp) {
		
		empService.updateEmp(emp);
		
		return "update success";
	}
	
	@DeleteMapping("/api/emp/delete/{id}")
	public String delete(@PathVariable Long id) {
		
		empService.deleteEmp(id);
		
		
		return "delete success";
	}
	
	@GetMapping("/api/emp/j2o")
	public String jsonToObjectMapping() {
		
		RestTemplate temp = new RestTemplate();
		
		Employee emp = temp.getForObject("http://localhost:8080/api/emp/4", Employee.class);
		
		return "FirsName = "+emp.getFname();
	}

	@GetMapping("/api/emp/ja2oa")
	public String jarrayToObjArray() {
		
		RestTemplate temp = new RestTemplate();
		
	Employee[] emplist= temp.getForObject("http://localhost:8080/api/emp/list", Employee[].class);
		
		
		return "FirstName ="+emplist[0].getFname();
	}
}

