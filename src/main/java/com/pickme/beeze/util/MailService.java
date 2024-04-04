package com.pickme.beeze.util;

import java.io.UnsupportedEncodingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender emailSender;
	
	// 이메일 발신
	public void sendEmail(String toEmail, String title, String text) {
		
		// 메일 발송 기능의 차이 SimpleMailMessage 단순 텍스트 전송 / MimeMessage 첨부파일 및 발신자 이름변경 가능 
        try {	// 예외처리를 하지않으면 자바에서 자동으로 예외처리 에러가 나타난다
        	MimeMessage message = creatMessage(toEmail, title, text);
            emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
	}
	
    // 메일 내용 작성
    public MimeMessage creatMessage(String toEmail, String title, String text) throws MessagingException, UnsupportedEncodingException {

    	MimeMessage message = emailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, toEmail);	// 메일 받을 사용자
        message.setSubject(title); 							// 이메일 제목
        message.setText(text, "utf-8", "html");				// 메일 내용, charset타입, subtype
        message.setFrom(new InternetAddress("pickme3592@gmail.com", "Pick ME")); // 보내는 사람의 이메일 주소, 보내는 사람 이름

        return message;
    }
	
}
