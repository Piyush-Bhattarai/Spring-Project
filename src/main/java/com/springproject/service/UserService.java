package com.springproject.service;

import com.springproject.model.User;

public interface UserService {

	
	void signup(User user);
		
	
	User login(String un, String psw);
		
		
	
}
