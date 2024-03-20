package com.pickme.beeze.login.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.login.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender emailSender;
	
	// 이메일 발신
	public void sendEmail(String toEmail, String title, String text) {
		
		SimpleMailMessage emailForm = createEmailForm(toEmail, title, text);
		
		emailSender.send(emailForm);

	}
	
	// 발신할 이메일 데이터 세팅
	private SimpleMailMessage createEmailForm(String toEmail, String title, String text) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject(title);
		message.setText(text);
		
		return message;
	}
}
