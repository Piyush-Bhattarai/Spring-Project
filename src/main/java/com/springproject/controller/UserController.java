package com.springproject.controller;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.model.User;
import com.springproject.service.UserService;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getLogin() {
	
		
		
		return "LoginForm";
	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		
		
		String username = user.getUsername().trim();
	    String password = user.getPassword().trim();

	    // Now check if either is empty and return an error before even hitting the database
	    if(username.isEmpty() || password.isEmpty()){
	        model.addAttribute("message", "Username or Password cannot be empty.");
	        return "LoginForm";
	    }

		
		User usr = userService.login(user.getUsername(), user.getPassword());
		
		if(usr != null) {
			
			session.setAttribute("validuser", usr);
			session.setMaxInactiveInterval(1000);
			
			//model.addAttribute("uname", user.getUsername());
			return "HomePage";
			
		}
		
		model.addAttribute("message", "Username or Password is invalid.");
		return "LoginForm";	
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		
		
		return "SignupForm";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user, Model model) {
	    
	    // Trim username and password
	    String username = user.getUsername().trim();
	    String password = user.getPassword().trim();
	    
	    // Trim first name and last name with null checks
	    String fname = user.getFname() != null ? user.getFname().trim() : "";
	    String lname = user.getLname() != null ? user.getLname().trim() : "";

	    // Define the pattern to allow letters, spaces, hyphens, and apostrophes in names
	    Pattern namePattern = Pattern.compile("^[A-Za-z\\s'-]+$");

	    // Now check if either username or password is empty
	    if(username.isEmpty() || password.isEmpty()) { 
	        model.addAttribute("message", "Username or Password cannot be empty.");
	        return "SignupForm";
	    }

	    // Check if the first name or last name contains special characters
	    if (namePattern.matcher(fname).matches() || namePattern.matcher(lname).matches()) {
	        model.addAttribute("message", "Special characters are not allowed in name sections.");
	        return "SignupForm";
	    }

	    // Proceed with the signup process
	    userService.signup(user);
	    
	    return "LoginForm";
	}
	
	@GetMapping("/profile")
	public String profile(HttpSession session) {
		
		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}
		
		
		return "Profile";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}
		
		session.invalidate();  // session kill  
		
		
		return "LoginForm";
	}
}
