package com.velue.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
@Service
public class EmailServiceImpl implements EmailService{


	@Override
	public void sendWelcomeEmail(String to1, String firstName) {
		String to="Jmanurkar@gmail.com";


		 // create a mail sender

			  JavaMailSender javaMailSender = new JavaMailSenderImpl();
			  SimpleMailMessage	  message = new SimpleMailMessage();
			  message.setSubject("Welcome to Devi Enterprises "); message.setText("Dear " +
			  firstName +
			  ",\n\nWelcome to Devi Enterprises. We're excited to have you onboard!\n\nBest regards,\nThe Devi Enterprises Team"
			  ); message.setTo(to); javaMailSender.send(message);
			 }



}