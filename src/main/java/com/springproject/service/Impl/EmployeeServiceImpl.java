package com.springproject.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.Employee;
import com.springproject.repository.EmployeeRepository;
import com.springproject.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void addEmp(Employee employee) {
		
		empRepo.save(employee);
		
	}

	@Override
	public void deleteEmp(Long id) {
		
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee employee) {
		
		empRepo.save(employee);
	}

	@Override
	public Employee getEmpById(Long id) {
		
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return empRepo.findAll();
	}

}
