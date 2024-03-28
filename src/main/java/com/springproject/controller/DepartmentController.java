package com.springproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.model.Department;
import com.springproject.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptservice;

	@GetMapping("/add")
	public String getDept(HttpSession session) {

		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		return "DepartmentForm";
	}

	@PostMapping("/add")
	public String postDept(@ModelAttribute Department dept, HttpSession session) {

		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		deptservice.addDept(dept);

		return "DepartmentForm";
	}

	@GetMapping("/list")
	public String getAll(Model model, HttpSession session) {

		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		model.addAttribute("deptList", deptservice.getAllDept());

		return "DepartmentList";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam int id, Model model, HttpSession session) { // @RequestParam == Access the "id"
																					// parameter value

		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		model.addAttribute("deptObj", deptservice.getDeptById(id));

		return "DepartmentEditForm";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Department dept, HttpSession session) {

		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		deptservice.addDept(dept);

		return "redirect:/department/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam int id, HttpSession session) {

		if (session.getAttribute("validuser") == null) {

			
			return "LoginForm";
		}

		deptservice.deleteDept(id);

		return "redirect:/department/list";
	}

	@GetMapping("/view")
	public String view(@RequestParam int id, Model model, HttpSession session) { // @RequestParam == Access the "id"
																					// parameter value

		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		model.addAttribute("deptObj", deptservice.getDeptById(id));

		return "DepartmentViewForm";
	}

}
