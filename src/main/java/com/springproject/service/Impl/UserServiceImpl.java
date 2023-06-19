package com.springproject.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.User;
import com.springproject.repository.UserRepository;
import com.springproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepo;

	@Override
	public void signup(User user) {
		
		userrepo.save(user);
		
	}

	@Override
	public User login(String un, String psw) {
		
		return userrepo.findByUsernameAndPassword(un, psw);
	}

}
