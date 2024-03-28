package com.springproject.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.utils.MailUtil;

@Controller
public class ContactController {

	@Autowired
	private MailUtil mailutil;

	@GetMapping("/contact")
	public String getContact(HttpSession session) {

		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		return "ContactForm";
	}

	@PostMapping("/contact")
	public String postContact(Model model, @RequestParam String toEmail, @RequestParam String subject,
			@RequestParam String message, HttpSession session) {

		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		mailutil.sendEmail(toEmail, subject, message);

		return "ContactForm";
	}

}
