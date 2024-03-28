package com.springproject.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.Department;
import com.springproject.repository.DepartmentRepository;
import com.springproject.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository deptrepo;

	@Override
	public void addDept(Department dept) {
		deptrepo.save(dept);
			
	}

	@Override
	public void deleteDept(int id) {
		
		deptrepo.deleteById(id);
		
	}

	@Override
	public void updateDept(Department dept) {
		
		deptrepo.save(dept);
		
	}

	@Override
	public Department getDeptById(int id) {
		
		return deptrepo.findById(id).get();
		
	}

	@Override
	public List<Department> getAllDept() {
		
	    return deptrepo.findAll();
	}

}
