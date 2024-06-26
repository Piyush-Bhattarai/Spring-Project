package com.springproject.utils;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Component
public class MailUtil {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(String toEmail, String subject, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        
        msg.setTo(toEmail);
        msg.setSubject(subject);
        msg.setText(message);

        javaMailSender.send(msg);

    }

}
