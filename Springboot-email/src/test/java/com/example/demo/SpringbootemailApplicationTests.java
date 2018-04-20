package com.example.demo;



import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringbootemailApplication.class)
public class SpringbootemailApplicationTests {
   @Autowired
   JavaMailSender mailsender;
	@Test
	public void sendEmail(){
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("gmg0829@163.com");
		message.setTo("gmg0829@qq.com");
		message.setSubject("主题邮件");
		message.setText("我是高明岗");
		mailsender.send(message);
	}
	@Test
	public void sendAttachementEmail() throws MessagingException{
		MimeMessage mimeMessage=mailsender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setFrom("gmg0829@163.com");
		mimeMessageHelper.setText("附件简历");
		mimeMessageHelper.setSubject("附件主题邮件");
		mimeMessageHelper.setTo("774131720@qq.com");
		FileSystemResource resource=new FileSystemResource(new File("高明岗.jpg"));
		mimeMessageHelper.addAttachment("附件一", resource);
		mailsender.send(mimeMessage);
	}

}
